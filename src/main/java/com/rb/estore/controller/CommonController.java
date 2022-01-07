package com.rb.estore.controller;

import com.rb.estore.database.InterfaceUserDao;
import com.rb.estore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    @Autowired
    InterfaceUserDao interfaceUserDAO;

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
