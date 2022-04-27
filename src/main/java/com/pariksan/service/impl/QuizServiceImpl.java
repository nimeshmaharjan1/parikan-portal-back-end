package com.pariksan.service.impl;

import com.pariksan.model.exam.Category;
import com.pariksan.model.exam.Quiz;
import com.pariksan.repo.QuizRepository;
import com.pariksan.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    //If the id is already present then the save function updates the value of the present id in the database
    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    @Override
    public List<Quiz> getQuizzesofCategory(Category category) {
        return this.quizRepository.findByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizess() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizessOfCategory(Category category) {
        return this.quizRepository.findByCategoryAndActive(category, true);
    }
}
