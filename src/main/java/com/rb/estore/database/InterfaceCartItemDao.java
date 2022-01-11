package com.rb.estore.database;

import com.rb.estore.model.CartItem;

public interface InterfaceCartItemDao {
    void addOrderItem(CartItem cartItem, int orderId);
}
