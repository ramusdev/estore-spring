package com.rb.estore.controller;

import com.rb.estore.model.view.RegisterUser;
import com.rb.estore.service.InterfaceAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationControlller {

    @Autowired
    InterfaceAuthenticationService interfaceAuthenticationService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerShow(Model model) {
        model.addAttribute("ruser", new RegisterUser());
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginShow() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        this.interfaceAuthenticationService.login(login, password);

        return "redirect:/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute RegisterUser registerUser) {

        // System.out.println("User name: ");
        // System.out.println(registerUser.getName());

        this.interfaceAuthenticationService.register(registerUser);

        return "redirect:/main";
    }


}
