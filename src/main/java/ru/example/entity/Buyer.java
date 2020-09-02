package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Buyer {
    @JsonProperty("firstName") private String firstName;
    @JsonProperty("lastName") private String lastName;

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

    public String getLasNname() {
        return lastName;
    }

    public void setLasNname(String lastName) {
        this.lastName = lastName;
    }

}
