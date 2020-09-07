package ru.example.entity.entityToJson;

public class Criterias2 implements CriteriasInterface {
    private String product_name;

    private int min_times;

    public Criterias2() {}

    public Criterias2(String product_name, int min_times) {
        this.product_name = product_name;
        this.min_times = min_times;
    }

    public int getMin_times() {
        return min_times;
    }

    public void setMin_times(int min_times) {
        this.min_times = min_times;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "(" + product_name + ", " + min_times + ")";
    }
}
