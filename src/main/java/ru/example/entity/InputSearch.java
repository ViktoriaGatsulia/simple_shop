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
 * Класс, описывающий входные данные для поиска
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class InputSearch implements InputMes {
    /**
     * Список критериев
     */
    private List<Criterias> criterias;

    /**
     * Пустой конструктор
     */
    public InputSearch() {}

    /**
     * Конструктор
     * @param criterias - список критериев
     */
    public InputSearch(List<Criterias> criterias) {
        this.criterias = criterias;
    }

    /**
     * Геттер
     * @return - список критериев
     */
    public List<Criterias> getCriterias() {
        return criterias;
    }

    /**
     * Сеттер
     * @param criterias - список критериев
     */
    public void setCriterias(List<Criterias> criterias) {
        this.criterias = criterias;
    }

}
