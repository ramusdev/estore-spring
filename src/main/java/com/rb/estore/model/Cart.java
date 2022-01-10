package com.rb.estore.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getSum() {
        double sum = 0.0;

        for (CartItem cartItem : cartItems) {
            sum += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }

        return Math.round(sum * 100) / 100.0;
    }

    public void clear() {
        this.cartItems = new ArrayList<>();
    }
}
