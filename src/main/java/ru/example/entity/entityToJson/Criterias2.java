package ru.example.entity.entityToJson;

/**
 * Класс описывающий критерий 2
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class Criterias2 implements CriteriasInterface {
    /**
     * Название товара
     */
    private String product_name;
    /**
     * Минимальное число раз, которые был куплен этот товар
     */
    private int min_times;

    /**
     * Пустой конструктор
     */
    public Criterias2() {}

    /**
     * Конструктор
     * @param product_name - название товара
     * @param min_times - минимальное число раз, которые был куплен этот товар
     */
    public Criterias2(String product_name, int min_times) {
        this.product_name = product_name;
        this.min_times = min_times;
    }

    /**
     * Геттер
     * @return - минимальное число раз
     */
    public int getMin_times() {
        return min_times;
    }

    /**
     * Сеттер
     * @param min_times - минимальное число раз
     */
    public void setMin_times(int min_times) {
        this.min_times = min_times;
    }

    /**
     * Геттер
     * @return - имя товара
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Сеттер
     * @param product_name - имя товара
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * Метод преобразования объекта в строку
     * @return - представление объекта в виде строки
     */
    @Override
    public String toString() {
        return "(" + product_name + ", " + min_times + ")";
    }
}
