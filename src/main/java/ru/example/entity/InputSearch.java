package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
public class InputSearch implements InputMes {
    private List<Criterias> criterias;

    public InputSearch() {}

    public InputSearch(List<Criterias> criterias) {
        this.criterias = criterias;
    }

    public List<Criterias> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<Criterias> criterias) {
        this.criterias = criterias;
    }

}
