package com.rb.estore.controllers;

import com.rb.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;

@Controller
public class CommonController {
    @Autowired
    Connection connection;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUser() {

        try {
            String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setString(2, "Name");
            preparedStatement.setString(3, "Surname");
            preparedStatement.setString(4, "Login");
            preparedStatement.setString(5, "Password");

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/main";
    }
}
