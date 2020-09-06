package ru.example;

import ru.example.convert.Converter;
import ru.example.entity.InputSearch;
import ru.example.entity.InputStat;

import java.io.IOException;

import static ru.example.convert.Converter.toJSON;
import static ru.example.convert.Converter.toJavaObject;
import static ru.example.service.StatisticService.statisticOnPeriod;


public class App {
    //  Database credentials

    public static void main(String[] argv) {

        if (argv.length < 3) {
            System.out.println("Недостаточно аргументов командной строки");
            System.exit(0);
        }

        if (argv[0].equals("search")) {
            try {
                InputSearch inputSearch = toJavaObject(argv[1], InputSearch.class);
                System.out.println(inputSearch.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (argv[0].equals("stat")) {
            try {
                InputStat inputStat = toJavaObject(argv[1], InputStat.class);
                System.out.println(inputStat.toString());

                toJSON(statisticOnPeriod(inputStat), argv[2]);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Неизвестная команда '" + argv[0] + "'");
            System.exit(0);
        }


    }

}

/*
mvn clean install && java -jar target/simple_shop-1.0-SNAPSHOT.jar
mvn compile && mvn package && java -jar target/simple_shop-1.0-SNAPSHOT.jar
java -jar target/simple_shop-1.0-SNAPSHOT-jar-with-dependencies.jar

mvn compile && mvn package && java -jar target/simple_shop-1.0-SNAPSHOT-jar-with-dependencies.jar stat exampleInputFile/exampleInputStat.json exampleOutputFile/output.json

 */