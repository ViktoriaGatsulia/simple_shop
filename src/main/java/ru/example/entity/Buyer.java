package ru.example.entity;

public class Buyer {
    private int id;
    private String firstName;
    private String lastName;

    public Buyer(String firstName, String lastName, int id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Buyer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{'first_name':'" + getFirstName() + "','last_name':'" + getLastName() + "'}";
    }

}
