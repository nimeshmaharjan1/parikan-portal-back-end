package com.pariksan.service;

import com.pariksan.model.exam.Question;
import com.pariksan.model.exam.Quiz;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long questionId);
    public Set<Question> getQuestionsOfQuiz(Quiz quiz);
    public void deleteQuestion(Long questionId);
    public Question getQuestionAnswer(Long questionId);
    public void save(MultipartFile file);
    public List<Question> getAllQuestions();
}
