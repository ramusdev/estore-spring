package com.rb.estore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProductController {
    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String productAddShow() {
        return "addproduct";
    }
}
