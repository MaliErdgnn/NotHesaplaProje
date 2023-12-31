package com.example.demo.controller2;

import com.example.demo.entity.HasDers;
import com.example.demo.entity.HasLab;
import com.example.demo.service2.HasLabService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odev/haslab")
@CrossOrigin
public class HasLabController {
    public HasLabService hasLabService;

    public HasLabController(HasLabService hasLabService) {
        this.hasLabService = hasLabService;
    }
    @GetMapping
    public List<HasLab> findAllbyId(){
        return hasLabService.findAll();
    }

    @PostMapping
    public HasLab saveHasLab(@RequestBody HasLab hasLab){
        return hasLabService.kaydetHasLab(hasLab);
    }
    @PutMapping
    public HasLab updateHasLab(@RequestBody HasLab hasLab){
        return hasLabService.guncelleHasLab(hasLab);
    }
    @DeleteMapping("/{id}")
    public void deleteHasLab(@PathVariable("id") Long id){
        hasLabService.silHasLab(id);
    }
}
