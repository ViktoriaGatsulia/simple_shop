package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Класс, описывающий продукт N-го магазина
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class Product implements Comparable<Product>{
    /**
     * Идентификатор продукта
     */
    @JsonIgnore private int id;
    /**
     * Название продукта
     */
    private String name;
    /**
     * Цена
     */
    private double price;

    /**
     * Конструктор
     * @param name - наименование товара
     * @param price - цена
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Конструктор
     * @param id - идентификатор товара
     * @param name - наименование
     * @param price - цена
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Геттер
     * @return - наименование товара
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер
     * @param name - наименование товара
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер
     * @return - цена товара
     */
    public double getPrice() {
        return price;
    }

    /**
     * Сеттер
     * @param price - цена товара
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Геттер
     * @return - идентификатор товара
     */
    public int getId() {
        return id;
    }

    /**
     * Сеттер
     * @param id - идентификатор товара
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод преобразования объекта в строку
     * @return - строковое представленние объекта
     */
    @Override
    public String toString() {
        return "{'product_name':'" + getName() + "','price':'" + getPrice() + "'}";
    }

    /**
     * Метод сравнения объектов класса Product
     * @param o - объект с которым идёт сравнение
     * @return - отрицательное целое число если данный объект меньше указанного
     * @return - нуль, елси данный объект равен указанному
     * @return - положительно целое число если данный объект больше указанного
     */
    @Override
    public int compareTo(Product o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
