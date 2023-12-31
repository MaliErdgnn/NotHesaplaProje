package com.example.demo.controller2;

import com.example.demo.entity.Proje;
import com.example.demo.entity.Quiz;
import com.example.demo.service2.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odev/quiz")
@CrossOrigin
public class QuizController {
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping("/{id}")
    public Optional<Quiz> getQuiz(@PathVariable("id") Long id){
        return quizService.getById(id);
    }
    @PostMapping
    public Quiz saveQuiz(@RequestBody Quiz quiz){
        return quizService.kaydet(quiz);
    }
    @PutMapping
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return quizService.guncelle(quiz);
    }
    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable("id") Long id){
        quizService.silQuiz(id);
    }
}
