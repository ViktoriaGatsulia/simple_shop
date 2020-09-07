package ru.example.entity;

import ru.example.entity.entityToJson.CriteriasInterface;
import ru.example.entity.entityToJson.OutCriterias;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс, описывающцй возвращаемую сущность при поиске по критериям
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class EntityResultSearch {
    /**
     * Критерий
     */
    private CriteriasInterface criteria;
    /**
     * Результаты поиска по этому критерию
     */
    private List<OutCriterias> results;

    /**
     * Пустой конструктор
     */
    public EntityResultSearch() {}

    /**
     * Геттер
     * @return - критерий
     */
    public CriteriasInterface getCriteria() {
        return criteria;
    }

    /**
     * Сеттер
     * @param criteria - критерий
     */
    public void setCriteria(CriteriasInterface criteria) {
        this.criteria = criteria;
    }

    /**
     * Геттер
     * @return - результаты поиска по критерию
     */
    public List<OutCriterias> getResults() {
        return results;
    }

    /**
     * Сеттер
     * @param results - результаты поиска по критериям
     */
    public void setResults(List<OutCriterias> results) {
        this.results = results;
    }

    /**
     * Метод для добавления результата поиска по критерию
     * @param outCriterias
     */
    public void addResult(OutCriterias outCriterias) {
        if (Objects.isNull(results)) results = new ArrayList<>();
        results.add(outCriterias);
    }
}
