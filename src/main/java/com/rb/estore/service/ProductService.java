package com.rb.estore.service;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements InterfaceProductService {
    @Autowired
    InterfaceProductDao interfaceProductDao;

    @Override
    public List<Product> getAllProducts() {
        return this.interfaceProductDao.getProducts();
    }
}
