package ru.example;

import com.sun.istack.internal.NotNull;
import ru.example.entity.Buyer;
import ru.example.entity.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Objects;

public class App {
    //  Database credentials

    public static void main(String[] argv) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/vikula", "vikula", "111");
            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM purchases;");

            while (resultSet.next()) {
                Buyer buyer = (Buyer) resultSet.getObject("buyer");
//                Product product = resultSet.getObject(2, Product.class);

                Date date = resultSet.getDate("date");

                System.out.println("Покупатель: " + buyer);
//                System.out.println("Тавар: " + product);
                System.out.println("Дата: " + date);
                System.out.println("\n===================\n");
            }

            conn.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

/*
mvn compile && mvn package && java -jar target/simple_shop-1.0-SNAPSHOT.jar
 */