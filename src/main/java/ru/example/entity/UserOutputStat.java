package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class UserOutputStat implements Comparable<UserOutputStat>{
    @JsonIgnore private int id;
    private String name;
    private List<Product> purchases;
    private double totalExpenses;

    public UserOutputStat() {
    }

    public UserOutputStat(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public UserOutputStat(String name, List<Product> purchases) {
        this.name = name;
        this.purchases = purchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
