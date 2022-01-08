package com.rb.estore.database;

import com.rb.estore.model.Product;

import java.util.List;

public interface InterfaceProductDao {
    List<Product> getProducts();
}
