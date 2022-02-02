package com.rb.estore.restcontroller;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Order;
import com.rb.estore.model.Product;
import com.rb.estore.model.User;
import com.rb.estore.service.InterfaceOrderService;
import com.rb.estore.service.InterfaceProductService;
import com.rb.estore.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rest")
public class RestCommonController {

    @Autowired
    InterfaceProductService productService;

    @Autowired
    InterfaceOrderService interfaceOrderService;

    @Autowired
    InterfaceUserService interfaceUserService;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return product;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable int id) {
        return interfaceOrderService.getOrderById(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        User user = interfaceUserService.getUserById(id);
        System.out.println("------------------ User ------------------");
        System.out.println(user.getName());

        return user;
    }
}
