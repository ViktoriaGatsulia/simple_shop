package ru.example.entity.entityToJson;

public class Criterias1 implements CriteriasInterface {
    private String last_name;

    public Criterias1(String last_name) {
        this.last_name = last_name;
    }

    public Criterias1() {}

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

}
