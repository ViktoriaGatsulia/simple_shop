package ru.example.entity;

import ru.example.entity.entityToJson.CriteriasInterface;
import ru.example.entity.entityToJson.OutCriterias;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EntityResultSearch {
    private CriteriasInterface criteria;
    private List<OutCriterias> results;

    public EntityResultSearch() {}


    public CriteriasInterface getCriteria() {
        return criteria;
    }

    public void setCriteria(CriteriasInterface criteria) {
        this.criteria = criteria;
    }

    public List<OutCriterias> getResults() {
        return results;
    }

    public void setResults(List<OutCriterias> results) {
        this.results = results;
    }

    public void addResult(OutCriterias outCriterias) {
        if (Objects.isNull(results)) results = new ArrayList<>();
        results.add(outCriterias);
    }
}
