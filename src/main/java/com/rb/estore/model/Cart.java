package com.rb.estore.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList();

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
