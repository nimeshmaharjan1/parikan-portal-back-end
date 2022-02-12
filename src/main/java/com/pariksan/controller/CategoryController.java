package com.pariksan.controller;

import com.pariksan.model.exam.Category;
import com.pariksan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Add Category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }
}
