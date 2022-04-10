package com.pariksan.controller;

import com.pariksan.helper.ExcelHelper;
import com.pariksan.model.exam.Question;
import com.pariksan.model.exam.Quiz;
import com.pariksan.service.QuestionService;
import com.pariksan.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;


    //ADD QUESTION
    @PostMapping("/")
    //Send question object back through ResponseEntity
    //We get data RequestBody in the form of json,  and we save that data in the question object created.
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //UPDATE QUESTION
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }
    
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {

        Quiz quiz = this.quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestions();
        List<Question> list = new ArrayList(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("quizId") Long quizId) {
       Quiz quiz = new Quiz();
       quiz.setQuizId(quizId);
       Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
       return ResponseEntity.ok(questionsOfQuiz);

    }

    //GET a question
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long questionId) {
        return this.questionService.getQuestion(questionId);
    }

    //DELETE QUESTION
    @DeleteMapping("/{questionId}")
        public void deleteQuestion(@PathVariable("questionId") Long questionId) {
            this.questionService.deleteQuestion(questionId);
    }
    //EVALUATE QUIZ
    @PostMapping("evaluate-quiz")
    public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions ) {
        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;
        int wrongAnswers = 0;

        for (Question q : questions) {
                Question question = this.questionService.getQuestionAnswer(q.getQuestionId());
                if (question.getAnswer().equals(q.getGivenAnswer())) {
                    correctAnswers++;
                    attempted++;
                    double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                    marksGot += marksSingle;
                } if (q.getGivenAnswer() != null) {
                    attempted++;
                } if (!Objects.equals(q.getGivenAnswer(), q.getAnswer())) {
                    wrongAnswers++;
                }
            }
            Map<Object, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted", attempted, "wrongAnswers", wrongAnswers);
        return ResponseEntity.ok(map);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) {
        if(ExcelHelper.checkExcelFormat(file)) {
            this.questionService.save(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and file is saved in the database"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload an excel file.");
    }
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return this.questionService.getAllQuestions();
    }
}
