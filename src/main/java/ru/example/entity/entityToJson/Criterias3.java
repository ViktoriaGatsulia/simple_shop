package ru.example.entity.entityToJson;

public class Criterias3 implements CriteriasInterface {
    private double min_expenses;

    private double max_expenses;

    public Criterias3() {}

    public Criterias3(double min_expenses, double max_expenses) {
        this.min_expenses = min_expenses;
        this.max_expenses = max_expenses;
    }

    public double getMax_expenses() {
        return max_expenses;
    }

    public void setMax_expenses(double max_expenses) {
        this.max_expenses = max_expenses;
    }

    public double getMin_expenses() {
        return min_expenses;
    }

    public void setMin_expenses(double min_expenses) {
        this.min_expenses = min_expenses;
    }
}
