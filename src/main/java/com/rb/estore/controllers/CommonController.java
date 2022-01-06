package com.rb.estore.controllers;

import com.rb.estore.database.InterfaceUserDAO;
import com.rb.estore.model.Product;
import com.rb.estore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;

@Controller
public class CommonController {
    @Autowired
    InterfaceUserDAO interfaceUserDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUser() {

        User user = new User(1, "Name", "Surname", "Login", "Password");
        interfaceUserDAO.addUser(user);

        return "redirect:/main";
    }
}
