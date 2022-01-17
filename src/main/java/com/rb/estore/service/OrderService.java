package com.rb.estore.service;

import com.rb.estore.database.InterfaceOrderDao;
import com.rb.estore.model.Order;
import com.rb.estore.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class OrderService implements InterfaceOrderService {

    @Autowired
    SessionObject sessionObject;

    @Autowired
    InterfaceOrderDao interfaceOrderDao;

    @Override
    public void confirmOrder() {
        Order order = new Order(this.sessionObject.getUser(), new HashSet<>(this.sessionObject.getCart().getOrderItems()));
        this.interfaceOrderDao.addOrder(order);
    }
}
