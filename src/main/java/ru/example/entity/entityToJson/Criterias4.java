package ru.example.entity.entityToJson;

/**
 * Класс описывающий критерий 4
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class Criterias4 implements CriteriasInterface {
    /**
     * Число пассивных покупателей
     */
    private int bad_customers;

    /**
     * Пустой конструктор
     */
    public Criterias4() {}

    /**
     * Конструктор
     * @param bad_customers - число пассивных покупателей
     */
    public Criterias4(int bad_customers) {
        this.bad_customers = bad_customers;
    }

    /**
     * Геттек
     * @return - число пассивных покупателей
     */
    public int getBad_customers() {
        return bad_customers;
    }

    /**
     * Сеттер
     * @param bad_customers - число пассивных покупателей
     */
    public void setBad_customers(int bad_customers) {
        this.bad_customers = bad_customers;
    }
}
