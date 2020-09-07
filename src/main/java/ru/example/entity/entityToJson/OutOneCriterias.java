package ru.example.entity.entityToJson;

/**
 * Класс, в котором хранятся пользоватли, найденные по критериям
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class OutOneCriterias implements OutCriterias {
    /**
     * Имя найденного пользователя
     */
    private String first_name;
    /**
     * Фамилия найденного пользователя
     */
    private String last_name;

    /**
     * Пустой конструктор
     */
    public OutOneCriterias() {}

    /**
     * Конструктор
     * @param first_name - имя пользователя
     * @param last_name - фамилия пользователя
     */
    public OutOneCriterias(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    /**
     * Геттер
     * @return - имя пользователя
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Сеттер
     * @param first_name - имя пользователя
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Геттер
     * @return - фамилия пользователя
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Сеттер
     * @param last_name - фамилия пользователя
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
