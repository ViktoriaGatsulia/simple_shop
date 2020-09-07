package ru.example;

import ru.example.convert.Converter;
import ru.example.entity.InputSearch;
import ru.example.entity.InputStat;
import ru.example.entity.SimpleError;

import java.io.IOException;

import static ru.example.convert.Converter.toJSON;
import static ru.example.convert.Converter.toJavaObject;
import static ru.example.service.SearchService.searchData;
import static ru.example.service.StatisticService.statisticOnPeriod;
import static ru.example.convert.Converter.toJSON;


public class App {

    public static void main(String[] argv) throws IOException {

        if (argv.length < 3) {
            String error = "Недостаточно аргументов командной строки";
            toJSON(new SimpleError("error", error), "error.json");
            System.out.println(error);
            System.exit(0);
        }

        String URL = "jdbc:postgresql://localhost:5432/vikula";
        String USER = "vikula";
        String PASSWD = "111";


        if (argv[0].equals("search")) {
            try {
                InputSearch inputSearch = toJavaObject(argv[1], InputSearch.class);
                toJSON(searchData(inputSearch, URL, USER, PASSWD), argv[2]);

            } catch (IOException e) {
                toJSON(new SimpleError("error", e.getMessage()), "error.json");
            }
        } else if (argv[0].equals("stat")) {
            try {
                InputStat inputStat = toJavaObject(argv[1], InputStat.class);
                toJSON(statisticOnPeriod(inputStat, URL, USER, PASSWD), argv[2]);

            } catch (IOException e) {
                toJSON(new SimpleError("error", e.getMessage()), "error.json");
            }
        } else {
            String error = "Неизвестная команда '" + argv[0] + "'";
            toJSON(new SimpleError("error", error), "error.json");
            System.out.println(error);
            System.exit(0);
        }


    }

}

/*
mvn clean install && java -jar target/simple_shop-1.0-SNAPSHOT.jar
mvn compile && mvn package && java -jar target/simple_shop-1.0-SNAPSHOT.jar
java -jar target/simple_shop-1.0-SNAPSHOT-jar-with-dependencies.jar

# stat
mvn compile && mvn package && java -jar target/simple_shop-1.0-SNAPSHOT-jar-with-dependencies.jar stat exampleInputFile/exampleInputStat.json exampleOutputFile/outputStat.json
# search
mvn compile && mvn package && java -jar target/simple_shop-1.0-SNAPSHOT-jar-with-dependencies.jar search exampleInputFile/exampleInputSearch.json exampleOutputFile/outputSearch.json

 */