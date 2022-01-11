package com.rb.estore.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private User user;
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;
    private List<CartItem> cartItems = new ArrayList<>();
    private LocalDateTime date;

    public Order(int id, User user, double price, Status status, List<CartItem> cartItems, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.status = status;
        this.cartItems = cartItems;
        this.date = date;
    }

    public Order(User user, List<CartItem> cartItems) {
        this.user = user;
        this.status = Status.NEW;
        this.cartItems = cartItems;
        this.date = LocalDateTime.now();

        calculateOrderPrice();
    }

    public Order() {

    }

    private void calculateOrderPrice() {
        this.price = 0.0;

        for (CartItem cartItem : this.cartItems) {
            this.price += cartItem.getProduct().getPrice() * cartItem.getQuantity();
            System.out.println("Price in");
            // System.out.println(cartItem.getProduct().getPrice());
            System.out.println(this.price);
        }

        this.price = Math.round(this.price * 100) / 100;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public enum Status {
        NEW,
        PAID,
        SENT,
        DELIVERED
    }
}
