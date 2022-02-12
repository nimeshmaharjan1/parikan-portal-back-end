package com.pariksan.repo;

import com.pariksan.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}