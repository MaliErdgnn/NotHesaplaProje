package com.example.demo.controller2;

import com.example.demo.entity.HasLab;
import com.example.demo.entity.HasOdev;
import com.example.demo.service2.HasOdevService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odev/hasodev")
@CrossOrigin
public class HasOdevController {
    private HasOdevService hasOdevService;

    public HasOdevController(HasOdevService hasOdevService) {
        this.hasOdevService = hasOdevService;
    }
    @GetMapping
    public List<HasOdev> findAllbyId(){
        return hasOdevService.findAll();
    }

    @PostMapping
    public HasOdev saveHasOdev(@RequestBody HasOdev hasOdev){
        return hasOdevService.kaydetHasOdev(hasOdev);
    }
    @PutMapping
    public HasOdev updateHasOdev(@RequestBody HasOdev hasOdev){
        return hasOdevService.guncelleHasOdev(hasOdev);
    }
    @DeleteMapping("/{id}")
    public void deleteHasOdev(@PathVariable("id") Long id){
        hasOdevService.silHasOdev(id);
    }
}
