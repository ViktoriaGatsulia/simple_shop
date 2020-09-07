package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс, описывающций входные данные для сбора статистики
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class InputStat implements InputMes{
    /**
     * Дата с которой начинается поиск (эта дата включается в результат)
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") private Date start_date;
    /**
     * Дата по которую идёт поиск (эта дата включается в результат)
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") private Date end_date;

    /**
     * Пооле для форматирования даты
     */
    @JsonIgnore private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Конструктор
     * @param start_date - дата с которой идёт поиск
     * @param end_date - дата по которую идёт поиск
     */
    public InputStat(Date start_date, Date end_date) {
        this.start_date = start_date;
        this.end_date = end_date;
    }

    /**
     * Пустой конструктор
     */
    public InputStat() {}

    /**
     * Геттер
     * @return - дата с которой начинается поиск
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * Сеттер
     * @param start_date - дата с которой начинается поиск
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * Геттер
     * @return - дата по которую идёт поиск
     */
    public Date getEnd_date() {
        return end_date;
    }

    /**
     * Сеттер
     * @param end_date - дата по которую идёт поиск
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    /**
     * Метод для преобразования объекта класса в строку
     * @return - строка, описывающая класс
     */
    @Override
    public String toString() {
        return "{\n" +
                "  'start_date' : '" + dateFormat.format(start_date) + "',\n" +
                "  'end_date' : '" + dateFormat.format(end_date) + "'\n" +
                "}";
    }
}
