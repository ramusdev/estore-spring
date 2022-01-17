package com.rb.estore.database.hibernate;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao implements InterfaceProductDao {
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public Optional<Product> getProductById(int productId) {
        return Optional.empty();
    }
}
