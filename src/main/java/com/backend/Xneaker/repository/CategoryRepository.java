package com.backend.Xneaker.repository;

import com.backend.Xneaker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
