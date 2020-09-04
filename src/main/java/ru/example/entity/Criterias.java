package ru.example.entity;

import com.fasterxml.jackson.annotation.*;

/**
 * {
 *   "criterias" : [
 *     {"last_name" : "Иванов"},
 *     {"product_name" : "Миниральная вода", "min_times" : 3},
 *     {"min_expenses" : 10, "max_expenses" : 250},
 *     {"bad_customers" : 2}
 *   ]
 * }
 */
@JsonIgnoreType
public class Criterias {

    private String last_name;
    private String product_name;
    private Integer min_times;
    private Double min_expenses;
    private Double max_expenses;
    private Integer bad_customers;

    public Criterias() {

    }

    public Criterias(String last_name) {
        this.last_name = last_name;
    }
    public Criterias(String product_name, Integer min_times) {
        this.product_name = product_name;
        this.min_times = min_times;
    }

    public Criterias(Double min_expenses, Double max_expenses) {
        this.min_expenses = min_expenses;
        this.max_expenses = max_expenses;
    }

    public Criterias(Integer bad_customers) {
        this.bad_customers = bad_customers;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getMin_times() {
        return min_times;
    }

    public void setMin_times(Integer min_times) {
        this.min_times = min_times;
    }

    public Double getMin_expenses() {
        return min_expenses;
    }

    public void setMin_expenses(Double min_expenses) {
        this.min_expenses = min_expenses;
    }

    public Double getMax_expenses() {
        return max_expenses;
    }

    public void setMax_expenses(Double max_expenses) {
        this.max_expenses = max_expenses;
    }

    public Integer getBad_customers() {
        return bad_customers;
    }

    public void setBad_customers(Integer bad_customers) {
        this.bad_customers = bad_customers;
    }

}
