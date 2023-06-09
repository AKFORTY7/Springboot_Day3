package com.telusko.ProductSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductDB db;

    public void addProduct(Product p){
//        products.add(p);

        db.save(p);

    }
//
    public List<Product> getAllProducts(){

        return db.findAll();
    }

    public Product getProduct(String name){
        Optional<Product> productOptional = db.findByName(name);
        return productOptional.orElse(null);
    }

    public List<Product> searchByText(String text) {
        return db.searchByText(text.toLowerCase());
    }

    public List<Product> searchByWarranty(int warranty) {
        return db.findByWarranty(warranty);
    }

    public List<Product> searchByPlace(String place) {
        return db.findByPlaceContainingIgnoreCase(place);
    }
}
