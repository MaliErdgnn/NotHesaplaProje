package com.example.demo.service2;

import com.example.demo.entity.HasQuiz;
import com.example.demo.repository.HasQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasQuizService {
    @Autowired
    private HasQuizRepository hasQuizRepository;

    public List<HasQuiz> findAll(){
        return hasQuizRepository.findAll();
    }
    public HasQuiz kaydetHasQuiz(HasQuiz hasQuiz){
        return hasQuizRepository.save(hasQuiz);
    }
    public HasQuiz guncelleHasQuiz(HasQuiz hasQuiz){
        return hasQuizRepository.save(hasQuiz);
    }
    public void silHasQuiz(Long id){
        hasQuizRepository.deleteById(id);
    }
}
