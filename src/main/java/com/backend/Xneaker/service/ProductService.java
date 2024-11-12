package com.backend.Xneaker.service;

import com.backend.Xneaker.model.Product;

import java.util.List;

public interface ProductService {
    Product CreateProduct(Product product);

    List<Product> getAllProduct();
    Product UpdateProduct(Product product , long id);
    Product deleteProduct(long id);

    //Optional<Object> findById(long );
}
