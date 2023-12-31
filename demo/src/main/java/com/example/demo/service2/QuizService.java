package com.example.demo.service2;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz kaydet(Quiz quiz){
        return quizRepository.save(quiz);
    }

    public Quiz guncelle(Quiz quiz){
        return quizRepository.save(quiz);
    }
    public void silQuiz(Long id){
        quizRepository.deleteById(id);
    }
    public Optional<Quiz> getById(Long id){
        return quizRepository.findById(id);
    }
}
