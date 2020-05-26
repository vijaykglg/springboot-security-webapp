package com.vijay.learn.sbsecurity.services;


import com.vijay.learn.sbsecurity.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
