package ru.example.service;

import ru.example.entity.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Objects;

import static ru.example.convert.Converter.toJSON;

/**
 * Класс для поиска по критериям
 */
public class SearchService {

    /**
     * Статический метод, отвечающий за формирование результатов поиска по критериям
     * @param inputSearch - входные данные, по которым собирается статистика
     * @return - статистика за период или сообщение об ошибке
     */
    public static OutputMes statisticOnPeriod(InputSearch inputSearch) throws IOException {
        /*
            Проверка на существование входных данных
         */
        if (Objects.isNull(inputSearch)) {
            System.err.println("Входное сообщение = null");
            return new SimpleError("error", "Входное сообщение = null");
        }

        /*
            Проверка на существование дат во входных данных
         */
        OutputStat outputStat = new OutputStat();
        if (Objects.isNull(inputStat.getStart_date()) || Objects.isNull(inputStat.getEnd_date())) {
            System.err.println("Неверно указан период");
            return new SimpleError("error", "Неверно указан период");
        }

        /*
            Проверка, верно ли дан период во входных данных
         */
        if (inputStat.getEnd_date().before(inputStat.getStart_date())) {
            System.err.println("Неверно указан период");
            return new SimpleError("error", "Неверно укзан период");
        }

        /*
            Расчёт количества дней в периоде
         */
        outputStat.setTotalDays(inputStat.getStart_date(), inputStat.getEnd_date());

        /*
            Подключение к БД с попыткой вытянуть данные о покупателях за период
         */
        try {
            /*
                Попытка открыть соединение с БД
                URL
                USER
                PASSWORD
             */
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/vikula", "vikula", "111");
            // conn.setAutoCommit(false);

            /*
                Создание SQL выражения для доступа к БД для общих целей
             */
            Statement stmt = conn.createStatement();

            /*
                Попытка получить множество строк в ответ на SQL запрос
             */
            ResultSet resultSet = stmt.executeQuery("SELECT b.id AS id_user, b.first_name, b.last_name, SUM(pr.price) AS sum_for_product, pr.id AS id_product, pr.name\n" +
                    "FROM buyer b\n" +
                    "JOIN purchases pur ON b.id = pur.buyer_id\n" +
                    "JOIN product pr ON pr.id = pur.product_id\n" +
                    "WHERE pur.date BETWEEN to_date('" + dateFormat.format(inputStat.getStart_date()) + "', 'yyyy-mm-dd') AND to_date('" + dateFormat.format(inputStat.getEnd_date()) + "', 'yyyy-mm-dd')\n" +
                    "GROUP BY b.id, pr.id;"
            );

            /*
                Построчная обработка результата выполнения SQL запроса
             */
            while (resultSet.next()) {
                int id_user = resultSet.getInt("id_user");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                double sum_for_product = resultSet.getDouble("sum_for_product");
                String name = resultSet.getString("name");
                int id_product = resultSet.getInt("id_product");
                Product product = new Product(id_product, name, sum_for_product);

                /*
                    Если в списке уже есть покупатель с таким же id
                    то просто добавляем ему новый товар, если нет,
                    то создаём нового пользователя
                    Если списка ещё нет то тоже создаём нового пользователя
                 */
                if (Objects.isNull(outputStat.getCustomers())) {
                    UserOutputStat user = new UserOutputStat();

                    user.setId(id_user);
                    user.setName(first_name + " " + last_name);

                    outputStat.addCustomers(user);
                }

                boolean flag = false; // пользователя с таким id нет
                for (UserOutputStat u : outputStat.getCustomers()) {
                    if (u.getId() == id_user) {
                        flag = true; // пользователь с таким id есть
                        break;
                    }
                }

                if (!flag) {
                    UserOutputStat user = new UserOutputStat();

                    user.setId(id_user);
                    user.setName(first_name + " " + last_name);

                    outputStat.addCustomers(user);
                }

                /*
                    К этому моменту пользователь с заданым id уже точно есть в списке,
                    осталось добавить ему товар
                 */
                for (UserOutputStat u : outputStat.getCustomers()) {
                    if (u.getId() == id_user) {
                        u.addProduct(product);
                        break;
                    }
                }

            }


            /*
                Вычисление суммы всех покупок всех покупателей
             */
            outputStat.setTotalExpenses();

            /*
                Вычисление средних затрат всех покупателей
             */
            outputStat.setAvgExpenses();

            /*
                Закрытие соединения с БД
             */
            conn.close();
        } catch (java.sql.SQLException e) {
            /*
                В случае вылета SQLException возвращаем объект
                с отчётом об ошибке
             */
            toJSON(new SimpleError("error", e.getMessage()), "error.json");
        }

        /*
            Возвращаем объект с инф о статистике за период
         */
        return outputStat;
    }

}
