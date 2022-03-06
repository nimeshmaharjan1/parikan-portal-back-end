package com.pariksan.repo;

import java.util.List;

import com.pariksan.model.exam.Category;
import com.pariksan.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    public List<Quiz> findByCategory(Category category);
    public List<Quiz> findByActive(Boolean isActive);
    public List<Quiz> findByCategoryAndActive(Category categoryActive, boolean isCategoryActive);
}