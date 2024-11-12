package com.backend.Xneaker.controller;


import com.backend.Xneaker.model.Product;
import com.backend.Xneaker.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Product/")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;



    @PostMapping("/postProduct")
    public ResponseEntity<Product> createCategory(@RequestParam Product product){
        Product p = productService.CreateProduct(product);
        return new ResponseEntity<>(p , HttpStatus.CREATED);

    }

    @GetMapping("/getProduct")
    public List<Product> getProductList()
    {
        return productService.getAllProduct();
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> UpdateProduct( @RequestBody Product p ,@RequestParam(name ="id") long id  ){
        Product updateP= productService.UpdateProduct(p , id);
        return new ResponseEntity<>(updateP, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Product> deleteCategory(@RequestParam (name = "id") long id){
        Product deletep = productService.deleteProduct(id);
        return new ResponseEntity<>(deletep , HttpStatus.OK);
    }

}
