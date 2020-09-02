package ru.example.entity;

import java.util.Date;

public class Purchases {
    private Buyer buyer;
    private Product product;
    private Date date;

    public Purchases(Buyer buyer, Product product, Date date) {
        this.buyer = buyer;
        this.product = product;
        this.date = date;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
