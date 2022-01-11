package com.rb.estore.service;

import com.rb.estore.database.InterfaceOrderDao;
import com.rb.estore.model.Order;
import com.rb.estore.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements InterfaceOrderService {

    @Autowired
    SessionObject sessionObject;

    @Autowired
    InterfaceOrderDao interfaceOrderDao;

    @Override
    public void confirmOrder() {
        Order order = new Order(this.sessionObject.getUser(), this.sessionObject.getCart().getCartItems());
        System.out.println("Order all price");
        System.out.println(order.getPrice());

        this.interfaceOrderDao.addOrder(order);
    }
}
