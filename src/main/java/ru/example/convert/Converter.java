package ru.example.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.example.entity.InputSearch;
import ru.example.entity.InputStat;

import java.io.File;
import java.io.IOException;

public class Converter {

    public static void toJSON(Object o, String baseFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), o);
        System.out.println("json created!");
    }

    public static <T> T toJavaObject(String baseFile, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), valueType);
    }

}