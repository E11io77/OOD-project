package com.myApp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class LocalProductRepository implements ProductRepository {
    private List <Product> products = new ArrayList<>();
    
    public void addProduct (Product product) {
        products.add(product);
    }
    @Override
    public List<Product> findAll() {
        return products;
    }
    @Override
    public Optional<Product> findByName (String name) {
        for (Product product: products) {
            if (product.getName().equals (name)) {
                return Optional.of(product); // pokud jsme našli
            }
        }
        return Optional.empty(); //pokud se nic nenajde
    }
   
    }