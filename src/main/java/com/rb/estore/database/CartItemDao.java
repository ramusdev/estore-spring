package com.rb.estore.database;

import com.rb.estore.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CartItemDao implements InterfaceCartItemDao {
    @Autowired
    Connection connection;

    @Override
    public void addOrderItem(CartItem cartItem, int orderId) {
        String sql = "INSERT INTO order_items VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2, orderId);
            preparedStatement.setInt(3, cartItem.getProduct().getId());
            preparedStatement.setInt(4, cartItem.getQuantity());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                cartItem.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
