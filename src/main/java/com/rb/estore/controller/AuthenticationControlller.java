package com.rb.estore.controllers;

import com.rb.estore.model.view.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationControlller {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerShow(Model model) {
        model.addAttribute("ruser", new RegisterUser());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute RegisterUser registerUser) {

        System.out.println("User name: ");
        System.out.println(registerUser.getName());

        this.authenticationService.register(registerUser);

        return "redirect:/main";
    }


}
