package com.backend.Xneaker.repository;

import com.backend.Xneaker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
