package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product implements Comparable<Product>{
    @JsonIgnore private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
