package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Purchases {
    @JsonIgnore private int id;
    private int buyer_id;
    private int product_id;
    private Date date;

    public Purchases(int id, int buyer_id, int product_id, Date date) {
        this.id = id;
        this.buyer_id = buyer_id;
        this.product_id = product_id;
        this.date = date;
    }

    public Purchases(int buyer_id, int product_id, Date date) {
        this.buyer_id = buyer_id;
        this.product_id = product_id;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
