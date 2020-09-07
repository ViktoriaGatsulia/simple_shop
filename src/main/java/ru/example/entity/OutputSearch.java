package ru.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс для сбора результатов поиска по критериям
 */
public class OutputSearch implements OutputMes {
    /**
     * Тип тела ответа
     */
    final private String type = "search";
    /**
     * Список результатов поиска по критериям
     */
    private List<EntityResultSearch> results;

    /**
     * Конструктор для сущности OutputSerch
     */
    public OutputSearch() {}

    /**
     * Геттер
     * @return - тип сообщения
     */
    public String getType() {
        return type;
    }

    /**
     * Сеттер
     * @param results - список результатов поиска по критериям
     */
    public void setResults(List<EntityResultSearch> results) {
        this.results = results;
    }

    /**
     * Геттер
     * @return - список результатов поиска по критериям
     */
    public List<EntityResultSearch> getResults() {
        return results;
    }

    /**
     * Доавбление результата поиска
     * @param entityResultSearch - добавляемый результат
     */
    public void addResult(EntityResultSearch entityResultSearch) {
        if (Objects.isNull(entityResultSearch)) return;
        if (Objects.isNull(results)) results = new ArrayList<>();
        results.add(entityResultSearch);
    }
}
