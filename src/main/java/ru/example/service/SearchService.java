package ru.example.service;

import ru.example.entity.*;
import ru.example.entity.entityToJson.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ru.example.convert.ConvertCriterias.convertCriterias;
import static ru.example.convert.Converter.toJSON;

/**
 * Класс для поиска по критериям
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class SearchService {

    /**
     * Статический метод, отвечающий за формирование результатов поиска по критериям
     * @param inputSearch - входные данные, по которым собирается статистика
     * @return - статистика за период или сообщение об ошибке
     */
    public static OutputMes searchData(InputSearch inputSearch, String URL, String USER, String PASSWD) throws IOException {
        /*
            Проверка на существование входных данных
         */
        if (Objects.isNull(inputSearch)) {
            System.err.println("Входное сообщение = null");
            return new SimpleError("error", "Входное сообщение = null");
        }

        /*
            Проверка на существование критериев во входных данных
         */
        if (Objects.isNull(inputSearch.getCriterias())) {
            System.err.println("Критерии в списке = null");
            return new SimpleError("error", "Критерии в списке = null");
        }

        List<CriteriasInterface> criteriasInterfaceList = new ArrayList<>();
        for(Criterias c : inputSearch.getCriterias()) {
            if (Objects.isNull(convertCriterias(c)))
                return new SimpleError("error", "Неизвестный критерий");
            criteriasInterfaceList.add(convertCriterias(c));
        }

        OutputSearch outputSearch = new OutputSearch();
        /*
            Подключение к БД
         */
        try {
            /*
                Попытка открыть соединение с БД
            */
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);

            /*
                Создание SQL выражения для доступа к БД для общих целей
             */
            Statement stmt = conn.createStatement();

            for (CriteriasInterface c : criteriasInterfaceList) {
                /*
                    Поиск по фамилии
                 */
                if (c.getClass() == Criterias1.class) {
                    ResultSet resultSet = stmt.executeQuery("SELECT first_name, last_name FROM buyer WHERE (last_name) LIKE '" + ((Criterias1) c).getLast_name() + "';");

                    EntityResultSearch result = new EntityResultSearch();
                    result.setCriteria(c);

                    while (resultSet.next()) {
                        String first_name = resultSet.getString("first_name");
                        String last_name = resultSet.getString("last_name");
                        result.addResult(new OutOneCriterias(first_name, last_name));
                    }
                    outputSearch.addResult(result);
                }
                /*
                    Поиск покупателей, купивших этот товар не менее, чем указанное число раз.
                 */
                if (c.getClass() == Criterias2.class) {
                    ResultSet resultSet = stmt.executeQuery("SELECT b.first_name, b.last_name, COUNT(pr.name) AS count_purchases\n" +
                            "FROM buyer b\n" +
                            "JOIN purchases pur ON b.id = pur.buyer_id\n" +
                            "JOIN product pr ON pr.id = pur.product_id\n" +
                            "WHERE (pr.name) LIKE '" + ((Criterias2) c).getProduct_name() + "'\n" +
                            "GROUP BY b.id\n" +
                            "HAVING COUNT(pr.name) >= " + ((Criterias2) c).getMin_times() + ";\n");

                    EntityResultSearch result = new EntityResultSearch();
                    result.setCriteria(c);

                    while (resultSet.next()) {
                        String first_name = resultSet.getString("first_name");
                        String last_name = resultSet.getString("last_name");
                        result.addResult(new OutOneCriterias(first_name, last_name));
                    }
                    outputSearch.addResult(result);
                }
                /*
                    Поиск покупателей, у которых общая стоимость всех покупок за всё время попадает в интервал
                 */
                if (c.getClass() == Criterias3.class) {
                    ResultSet resultSet = stmt.executeQuery("SELECT b.id, b.first_name, b.last_name,\n" +
                            "SUM(pr.price) AS total_sum\n" +
                            "FROM buyer b\n" +
                            "JOIN purchases pur ON b.id = pur.buyer_id\n" +
                            "JOIN product pr ON pr.id = pur.product_id\n" +
                            "GROUP BY b.id\n" +
                            "HAVING SUM(pr.price) BETWEEN " + ((Criterias3) c).getMin_expenses() + " AND " + ((Criterias3) c).getMax_expenses() + ";");

                    EntityResultSearch result = new EntityResultSearch();
                    result.setCriteria(c);

                    while (resultSet.next()) {
                        String first_name = resultSet.getString("first_name");
                        String last_name = resultSet.getString("last_name");
                        result.addResult(new OutOneCriterias(first_name, last_name));
                    }
                    outputSearch.addResult(result);
                }
                /*
                    Поиск покупателей, купивших меньше всего товаров
                 */
                if (c.getClass() == Criterias4.class) {
                    ResultSet resultSet = stmt.executeQuery("SELECT b.id, b.first_name, b.last_name,\n" +
                            "SUM(pr.price) AS total_sum\n" +
                            "FROM buyer b\n" +
                            "JOIN purchases pur ON b.id = pur.buyer_id\n" +
                            "JOIN product pr ON pr.id = pur.product_id\n" +
                            "GROUP BY b.id\n" +
                            "ORDER BY total_sum ASC\n" +
                            "LIMIT " + ((Criterias4) c).getBad_customers() + ";");

                    EntityResultSearch result = new EntityResultSearch();
                    result.setCriteria(c);

                    while (resultSet.next()) {
                        String first_name = resultSet.getString("first_name");
                        String last_name = resultSet.getString("last_name");
                        result.addResult(new OutOneCriterias(first_name, last_name));
                    }
                    outputSearch.addResult(result);
                }
            }

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
        return outputSearch;
    }

}
