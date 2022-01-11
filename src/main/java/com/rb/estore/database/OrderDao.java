package com.rb.estore.database;

import com.rb.estore.model.CartItem;
import com.rb.estore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class OrderDao implements InterfaceOrderDao {

    @Autowired
    Connection connection;

    @Autowired
    InterfaceCartItemDao interfaceCartItemDao;


    @Override
    public void addOrder(Order order) {
        String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2, order.getUser().getId());
            preparedStatement.setDouble(3, order.getPrice());
            preparedStatement.setString(4, order.getStatus().toString());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(order.getDate()));

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }

            for (CartItem cartItem : order.getCartItems()) {
                this.interfaceCartItemDao.addOrderItem(cartItem, order.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
