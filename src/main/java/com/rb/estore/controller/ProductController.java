package com.rb.estore.controller;

import com.rb.estore.model.Product;
import com.rb.estore.service.ProductService;
import com.rb.estore.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SessionObject sessionObject;

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String productAddShow(Model model) {
        model.addAttribute("rproduct", new Product());

        if (this.sessionObject.isLogged()) {
            return "addproduct-b";
        }

        return "redirect:/main";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String productAdd(@ModelAttribute Product product) {
        System.out.println(product.getTitle());
        productService.addProduct(product);

        return "redirect:/main";
    }
}
