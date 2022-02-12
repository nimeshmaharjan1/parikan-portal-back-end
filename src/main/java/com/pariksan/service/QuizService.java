package com.pariksan.service;

import com.pariksan.model.exam.Quiz;

import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes(Quiz quiz);
    public Quiz getQuiz(Long quizId);
    public void deleteQuiz(Long quizId);
}
