package com.pariksan.controller;

import java.util.List;

import com.pariksan.model.exam.Category;
import com.pariksan.model.exam.Quiz;
import com.pariksan.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    //CREATE Quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
    //UPDATE Quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //GET Quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }
    //GET Single Quiz
    @GetMapping("/{quizId}")
    public Quiz quiz(@PathVariable("quizId") Long quizId) {
        return this.quizService.getQuiz(quizId);
    }

    //DELETE Quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId) {
        this.quizService.deleteQuiz(quizId);
    }

    //TO GET THE QUIZZES OF A PARTICULAR CATEGORY
    @GetMapping("/category/{categoryId}")
    public List<Quiz> getQuizzesofCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return this.quizService.getQuizzesofCategory(category);
    }

    //GET ACTIVE QUIZZES 
    @GetMapping("/active-quizzes")
    public List<Quiz> getActiveQuizzes() {
        return this.quizService.getActiveQuizess();
    }

    //GET ACTIVE QUIZZES OF CATEGORY 
    @GetMapping("/category/active/{categoryId}")
    public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return this.quizService.getActiveQuizessOfCategory(category);
    }
}
