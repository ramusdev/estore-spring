package com.rb.estore.controller;

import com.rb.estore.service.InterfaceCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @Autowired
    InterfaceCartService interfaceCartService;

    @RequestMapping(value = "/cart/add/{productId}", method = RequestMethod.GET)
    public String addProductToCart(@PathVariable Integer productId) {
        System.out.println(productId);
        this.interfaceCartService.addProductToCart(productId);

        return "redirect:/main";
    }
}
