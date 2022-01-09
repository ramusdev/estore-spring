package com.rb.estore.service;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements InterfaceProductService {
    @Autowired
    InterfaceProductDao interfaceProductDao;

    @Override
    public List<Product> getAllProducts() {
        return this.interfaceProductDao.getProducts();
    }

    @Override
    public void addProduct(Product product) {
        this.interfaceProductDao.addProduct(product);
    }
}
