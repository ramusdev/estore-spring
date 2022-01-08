package com.rb.estore.model;

import javax.persistence.*;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int code;
    private double price;
    private int quantity;

    public Product(int id, String title, int code, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
