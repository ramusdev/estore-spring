package com.rb.estore.controllers;

import com.rb.estore.model.view.RegisterUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationControlller {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerShow(Model model) {
        model.addAttribute("ruser", new RegisterUser());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute RegisterUser registerUser) {

        System.out.println("User name: ");
        System.out.println(registerUser.getName());

        return "redirect:/main";
    }


}
