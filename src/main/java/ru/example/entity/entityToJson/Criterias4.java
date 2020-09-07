package ru.example.entity.entityToJson;

public class Criterias4 implements CriteriasInterface {
    private int bad_customers;

    public Criterias4() {}

    public Criterias4(int bad_customers) {
        this.bad_customers = bad_customers;
    }

    public int getBad_customers() {
        return bad_customers;
    }

    public void setBad_customers(int bad_customers) {
        this.bad_customers = bad_customers;
    }
}
