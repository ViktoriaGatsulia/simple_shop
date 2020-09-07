package ru.example.entity.entityToJson;

/**
 * Класс описывающий критерий 3
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class Criterias3 implements CriteriasInterface {
    /**
     * Минимальная стоимость всех покупок
     */
    private double min_expenses;
    /**
     * Максимальная стоимость всех покупок
     */
    private double max_expenses;

    /**
     * Пустой конструктор
     */
    public Criterias3() {}

    /**
     * Конструктор
     * @param min_expenses - минимальная стоимость всех покупок
     * @param max_expenses - максимальная стооимость всех покупок
     */
    public Criterias3(double min_expenses, double max_expenses) {
        this.min_expenses = min_expenses;
        this.max_expenses = max_expenses;
    }

    /**
     * Геттер
     * @return - максимальная стоимость всех покупок
     */
    public double getMax_expenses() {
        return max_expenses;
    }

    /**
     * Сеттер
     * @param max_expenses - максимальная стоимость всех покупок
     */
    public void setMax_expenses(double max_expenses) {
        this.max_expenses = max_expenses;
    }

    /**
     * Геттер
     * @return - минимальная стоимость всех покупок
     */
    public double getMin_expenses() {
        return min_expenses;
    }

    /**
     * Сеттер
     * @param min_expenses - минимальная стоимость всех покупок
     */
    public void setMin_expenses(double min_expenses) {
        this.min_expenses = min_expenses;
    }
}
