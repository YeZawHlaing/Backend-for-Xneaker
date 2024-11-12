package com.backend.Xneaker.service.serviceImp;


import com.backend.Xneaker.model.Product;
import com.backend.Xneaker.repository.ProductRepository;
import com.backend.Xneaker.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    @Autowired
    private final  ProductRepository productRepository;

    @Override
    public Product CreateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product UpdateProduct(Product product, long id) {
        Product is_exit = productRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Error in CustomerName"));
        is_exit.setName(product.getName());
        is_exit.setPrice(product.getPrice());
        is_exit.setDescription(product.getDescription());
        is_exit.setReview(product.getReview());
        is_exit.setNumber(product.getNumber());


        return is_exit;
    }

    @Override
    public Product deleteProduct(long id) {
        Product is_exit = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Error in CustomerName"));
        productRepository.deleteById(id);
        return is_exit;
    }
}
