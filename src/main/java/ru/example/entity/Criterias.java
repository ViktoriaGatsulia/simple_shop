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
 *
 * Общий класс для описания входных критериев
 * @author ViktoriaGatsulia
 * @version 1.0
 */
//@JsonIgnoreType
public class Criterias {
    /**
     * Фамилия покупателя
     */
    private String last_name;
    /**
     * Название товара
     */
    private String product_name;
    /**
     * Минимально число раз, которые покупался этот товар
     */
    private Integer min_times;
    /**
     * Минимальноая общая стоимость всех покупок
     */
    private Double min_expenses;
    /**
     * Максимальная общая стоимость всех покупок
     */
    private Double max_expenses;
    /**
     * Число пассивных покупателей
     */
    private Integer bad_customers;

    /**
     * Пустой конструктор
     */
    public Criterias() {}

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

    /**
     * Геттер
     * @return - наименование товара
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Сеттер
     * @param product_name - наименование товара
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * Геттер
     * @return - минимальное число покупок конкретного товара
     */
    public Integer getMin_times() {
        return min_times;
    }

    /**
     * Сеттер
     * @param min_times - минимальное число покупок конкретного товара
     */
    public void setMin_times(Integer min_times) {
        this.min_times = min_times;
    }

    /**
     * Геттер
     * @return - минимальная общая стоимость всех покупок
     */
    public Double getMin_expenses() {
        return min_expenses;
    }

    /**
     * Сеттер
     * @param min_expenses - минимальная общая стоимость всех покупок
     */
    public void setMin_expenses(Double min_expenses) {
        this.min_expenses = min_expenses;
    }

    /**
     * Геттер
     * @return - максимальная общая стоимость всех покупок
     */
    public Double getMax_expenses() {
        return max_expenses;
    }

    /**
     * Сеттер
     * @param max_expenses - максимальная общая стоимость всех покупок
     */
    public void setMax_expenses(Double max_expenses) {
        this.max_expenses = max_expenses;
    }

    /**
     * Геттер
     * @return - количество пассивных покупателей
     */
    public Integer getBad_customers() {
        return bad_customers;
    }

    /**
     * Сеттер
     * @param bad_customers - количество пассивных покупателей
     */
    public void setBad_customers(Integer bad_customers) {
        this.bad_customers = bad_customers;
    }

}
