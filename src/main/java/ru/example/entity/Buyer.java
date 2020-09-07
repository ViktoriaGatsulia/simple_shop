package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Абстрактный класс, описвыающий покупателя
 * @author ViktoriaGatsulia
 * @version 1.0
 */
abstract public class Buyer {
    /**
     * Идентификатор пользователя
     */
    private int id;
    /**
     * Имя пользователя
     */
    private String firstName;
    /**
     * Фамилия пользоватлея
     */
    private String lastName;
}
