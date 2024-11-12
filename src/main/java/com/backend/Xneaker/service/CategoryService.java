package com.backend.Xneaker.service;

import com.backend.Xneaker.model.Category;

import java.util.List;

public interface CategoryService {
    Category CreateCategory(Category category);

    List<Category> getAllCategory();
  //  Category UpdateCategory(Category category , int id);

    Category UpdateCategory(Category category, long id);

    Category deleteCategory(long id);

}
