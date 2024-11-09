package com.backend.Xneaker.repository;
import com.backend.Xneaker.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    Optional<Seller> findByName(String name);
    Optional<Seller> findByEmail(String email);

}
