package com.rb.estore.service;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements InterfaceCartService {

    @Autowired
    InterfaceProductDao interfaceProductDao;

    @Override
    public void addProductToCart(int productId) {
        Optional<Product> productOptional = this.interfaceProductDao.getProductById(productId);

        if (productOptional.isEmpty()) {
            return;
        }

        if (productOptional.get().getQuantity() < 0) {
            return;
        }

        // System.out.println(productOptional.get().getTitle());
    }
}
