package ru.example.convert;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Класс для преобразования из java-объекта в JSON и обратно
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class Converter {
    /**
     * Преобразование java-объекта в JSON
     * @param o - объект, который нужно преобразовать
     * @param baseFile - файл, в который нужно записать преобразование
     * @throws IOException - стандартные искллючения ввода-вывода
     */
    public static void toJSON(Object o, String baseFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), o);
        System.out.println("json created!");
    }

    /**
     * Преобразование из JSON в java-объекты
     * @param baseFile - файл, из которого нужно извлечь SON
     * @param valueType - класс, к которому нужно преобразовать
     * @param <T> - тип, к которому нужно преобразовать
     * @return - сформированный объект
     * @throws IOException - стандартные исключения ввода-вывода
     */
    public static <T> T toJavaObject(String baseFile, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), valueType);
    }

}