package com.rb.estore.controller;

import com.rb.estore.model.Cart;
import com.rb.estore.service.InterfaceCartService;
import com.rb.estore.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @Autowired
    SessionObject sessionObject;

    @Autowired
    InterfaceCartService interfaceCartService;

    @RequestMapping(value = "/cart/add/{productId}", method = RequestMethod.GET)
    public String addProductToCart(@PathVariable Integer productId) {
        System.out.println(productId);
        this.interfaceCartService.addProductToCart(productId);

        return "redirect:/main";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartShow(Model model) {
        Cart cart = this.sessionObject.getCart();
        model.addAttribute("cart", cart);

        return "cart";
    }

    @RequestMapping(value="/cart/clear", method = RequestMethod.GET)
    public String cartClear() {
        this.sessionObject.getCart().clear();
        return "redirect:/cart";
    }
}
