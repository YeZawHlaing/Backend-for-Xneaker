package com.backend.Xneaker.service.serviceImp;


import com.backend.Xneaker.model.Category;
import com.backend.Xneaker.repository.CategoryRepository;
import com.backend.Xneaker.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public Category CreateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }



    @Override
    public Category UpdateCategory(Category category, long id) {
        Category is_exit = categoryRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Error in CustomerName"));
        is_exit.setName(category.getName());
        is_exit.setPrice(category.getPrice());
        is_exit.setDescription(category.getDescription());
        is_exit.setReview(category.getReview());
        is_exit.setNumber(category.getNumber());
        is_exit.setCategory_Name(category.getCategory_Name());


        return is_exit;
    }




    @Override
    public Category deleteCategory(long id) {
        Category is_exit = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Error in CustomerName"));
        categoryRepository.deleteById(id);
        return is_exit;
    }
}
