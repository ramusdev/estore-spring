package com.rb.estore.service;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.CartItem;
import com.rb.estore.model.Product;
import com.rb.estore.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements InterfaceCartService {

    @Autowired
    InterfaceProductDao interfaceProductDao;

    @Autowired
    SessionObject sessionObject;

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

        for (CartItem cartItem : this.sessionObject.getCart().getCartItems()) {
            if (cartItem.getProduct().getId() == productId) {
                cartItem.incrementQuantity();
                return;
            }
        }

        CartItem cartItem = new CartItem(0, productOptional.get(), 1);
        this.sessionObject.getCart().getCartItems().add(cartItem);

    }
}
