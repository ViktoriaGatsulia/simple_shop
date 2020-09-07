package ru.example.entity;

/**
 * Класс, описывающий вывод ошибок
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class SimpleError implements OutputMes {
    /**
     * Тип ошибки
     */
    private String type;
    /**
     * Сообщение с кратким описанием проблемы
     */
    private String message;

    /**
     * Конструктор
     * @param type - тип ошибки
     * @param message - краткое её описание
     */
    public SimpleError(String type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * Геттер
     * @return - тип
     */
    public String getType() {
        return type;
    }

    /**
     * Сеттер
     * @param type - тип
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Геттер
     * @return - краткое сообщение
     */
    public String getMessage() {
        return message;
    }

    /**
     * Сеттер
     * @param message - краткое сообщение
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
