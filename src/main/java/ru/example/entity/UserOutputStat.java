package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Класс, описывающий пользователя при выводе статистики
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class UserOutputStat implements Comparable<UserOutputStat>{
    /**
     * Идентификатор пользователя
     */
    @JsonIgnore private int id;
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Список его покупок
     */
    private List<Product> purchases;
    /**
     * Общие затраты покупателя
     */
    private double totalExpenses;

    /**
     * Пустой конструктор
     */
    public UserOutputStat() {
    }

    /**
     * Конструктор
     * @param id - идентификатор
     * @param name - имя
     */
    public UserOutputStat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Конструктор
     * @param name - имя
     * @param purchases - покупки
     */
    public UserOutputStat(String name, List<Product> purchases) {
        this.name = name;
        this.purchases = purchases;
    }

    /**
     * Геттер
     * @return - имя
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер
     * @param name - имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер
     * @return - покупки
     */
    public List<Product> getPurchases() {
        if (Objects.isNull(purchases)) return new ArrayList<>();

        purchases.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -(Double.compare(o1.getPrice(), o2.getPrice()));
            }
        });
        return purchases;
    }

    /**
     * Сеттер
     * @param purchases - покупки
     */
    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }

    /**
     * Геттер
     * @return - общие затраты
     */
    public double getTotalExpenses() {
        return totalExpenses;
    }

    /**
     * Сеттер, вычисление общих затрат
     */
    public void setTotalExpenses() {
        if (Objects.isNull(purchases)) {
            this.totalExpenses = 0;
        } else {
            this.totalExpenses = 0;
            for (Product p : purchases) {
                this.totalExpenses += p.getPrice();
            }
        }
    }

    /**
     * Метод для добавления продукта в список покупок
     * @param product - добавляемый товар
     */
    public void addProduct(Product product) {
        if (Objects.isNull(product)) {
            return;
        }

        if (Objects.isNull(purchases)) {
            purchases = new ArrayList<>();
        }
        purchases.add(product);
        setTotalExpenses();
    }

    /**
     * Метод сравнения объектов класса UserOutputStat
     * @param o - объект с которым идёт сравнение
     * @return - отрицательное целое число если данный объект меньше указанного
     * @return - нуль, елси данный объект равен указанному
     * @return - положительно целое число если данный объект больше указанного
     */
    @Override
    public int compareTo(UserOutputStat o) {
        return Double.compare(this.getTotalExpenses(), o.getTotalExpenses());
    }

    /**
     * Геттер
     * @return - идентификатор покупателя
     */
    public int getId() {
        return id;
    }

    /**
     * Сеттер
     * @param id - идентификатор покупателя
     */
    public void setId(int id) {
        this.id = id;
    }
}
