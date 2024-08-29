package com.services;

import com.model.Product;

import java.util.List;

public interface ProductServices {

    void addProduct(Product p);
    void deleteProduct(int index) ;
    List<Product> getAllProducts() ;
    void updateProduct(Product p,int id);
}
