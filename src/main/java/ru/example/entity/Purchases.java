package ru.example.entity;
import java.util.Date;

/**
 * Абстрактный клас, описывающий покупки
 * @author ViktoriaGatsulia
 * @version 1.0
 */
abstract public class Purchases {
    /**
     * Идентификатор покупки
     */
    private int id;
    /**
     * Покупатель
     */
    private int buyer_id;
    /**
     * Наименование товара
     */
    private int product_id;
    /**
     * Дата, когда была совершена покупка
     */
    private Date date;
}
