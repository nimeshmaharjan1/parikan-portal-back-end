package com.pariksan.service;

import com.pariksan.model.exam.Category;
import org.springframework.context.annotation.Bean;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);

    //To get set of categories all together
    public Set<Category> getCategories();

    public Category getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);
}
