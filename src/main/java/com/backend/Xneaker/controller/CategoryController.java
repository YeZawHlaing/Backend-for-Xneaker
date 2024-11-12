package com.backend.Xneaker.controller;


import com.backend.Xneaker.model.Category;
import com.backend.Xneaker.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Category/")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/postCategory")
    public ResponseEntity<Category> createCategory(@RequestParam Category category){
        Category create_Cut = categoryService.CreateCategory(category);
        return new ResponseEntity<>(create_Cut , HttpStatus.CREATED);

    }

    @GetMapping("/getCategory")
    public List<Category> getCategoryList()
    {
        return categoryService.getAllCategory();
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category , @RequestParam(name ="id") long id ){
        Category updateCategory = categoryService.UpdateCategory( category, id);
        return new ResponseEntity<>(updateCategory , HttpStatus.OK);
    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<Category> deleteCategory(@RequestParam (name = "id") long id){
        Category deleteCut=categoryService.deleteCategory(id);
        return new ResponseEntity<>(deleteCut,HttpStatus.OK);
    }
}
