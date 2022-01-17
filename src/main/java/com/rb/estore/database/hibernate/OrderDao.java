package com.rb.estore.database.hibernate;

import com.rb.estore.database.InterfaceOrderDao;
import com.rb.estore.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao implements InterfaceOrderDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }


    }
}
