package ru.example.entity.entityToJson;

/**
 * Класс, описывающий критерий 1
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class Criterias1 implements CriteriasInterface {
    /**
     * Фамилия покупателя
     */
    private String last_name;

    /**
     * Конструктор
     * @param last_name - фамилия покупателя
     */
    public Criterias1(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Пустой конструктор
     */
    public Criterias1() {}

    /**
     * Геттер
     * @return - фамилия покупателя
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Сеттер
     * @param last_name - фамилия покупателя
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

}
