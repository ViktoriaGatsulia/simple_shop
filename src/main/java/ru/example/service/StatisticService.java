package ru.example.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.example.entity.InputStat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class StatisticService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void statisticOnPeriod(InputStat inputStat) {
        if (Objects.isNull(inputStat)) return;

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/vikula", "vikula", "111");
//            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT b.first_name, b.last_name, pr.name, pr.price , pur.date\n" +
                    "FROM buyer b\n" +
                    "JOIN purchases pur ON b.id = pur.buyer_id\n" +
                    "JOIN product pr ON pr.id = pur.product_id\n" +
                    "WHERE pur.date BETWEEN to_date('" + dateFormat.format(inputStat.getStart_date()) + "', 'yyyy-mm-dd') AND to_date('" + dateFormat.format(inputStat.getEnd_date()) + "', 'yyyy-mm-dd');\n");

            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String product_name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Date date = resultSet.getDate("date");
                System.out.println("Имя: " + first_name);
                System.out.println("Фамилия: " + last_name);
                System.out.println("Товар: " + product_name);
                System.out.println("Цена: " + price);
                System.out.println("Дата: " + date);
                System.out.println("\n===================\n");
            }

            conn.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
