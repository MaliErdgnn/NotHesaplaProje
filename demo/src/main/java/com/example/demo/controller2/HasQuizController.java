package com.example.demo.controller2;

import com.example.demo.entity.HasProje;
import com.example.demo.entity.HasQuiz;
import com.example.demo.service2.HasQuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odev/hasquiz")
@CrossOrigin
public class HasQuizController {
    private HasQuizService hasQuizService;

    public HasQuizController(HasQuizService hasQuizService) {
        this.hasQuizService = hasQuizService;
    }
    @GetMapping
    public List<HasQuiz> findAllbyId(){
        return hasQuizService.findAll();
    }

    @PostMapping
    public HasQuiz saveHasQuiz(@RequestBody HasQuiz hasQuiz){
        return hasQuizService.kaydetHasQuiz(hasQuiz);
    }
    @PutMapping
    public HasQuiz updateHasQuiz(@RequestBody HasQuiz hasQuiz){
        return hasQuizService.guncelleHasQuiz(hasQuiz);
    }
    @DeleteMapping("/{id}")
    public void deleteHasQuiz(@PathVariable("id") Long id){
        hasQuizService.silHasQuiz(id);
    }
}
