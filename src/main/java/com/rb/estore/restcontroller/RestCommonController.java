package com.rb.estore.restcontroller;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Order;
import com.rb.estore.model.Product;
import com.rb.estore.model.User;
import com.rb.estore.model.dto.OrderDto;
import com.rb.estore.service.InterfaceOrderService;
import com.rb.estore.service.InterfaceProductService;
import com.rb.estore.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public OrderDto getOrder(@PathVariable int id) {
        Order order = interfaceOrderService.getOrderById(id);
        OrderDto orderDto = new OrderDto(order);

        return orderDto;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        User user = interfaceUserService.getUserById(id);

        return user;
    }

    @RequestMapping(value = "/product/addproduct", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        System.out.println("--------- Add product -------------------------------");
        System.out.println(product.getTitle());
    }
}
