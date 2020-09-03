package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import org.postgresql.util.PGBinaryObject;
import org.postgresql.util.PGobject;

import java.io.Serializable;
import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.sql.*;

public class Buyer {
    private String firstName;
    private String lastName;

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

    @Override
    public String toString() {
        return "{'" + getFirstName() + "','" + getLastName() + "'}";
    }

}
