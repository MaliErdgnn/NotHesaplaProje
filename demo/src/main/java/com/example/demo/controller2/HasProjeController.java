package com.example.demo.controller2;

import com.example.demo.entity.HasOdev;
import com.example.demo.entity.HasProje;
import com.example.demo.service2.HasProjeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odev/hasproje")
@CrossOrigin
public class HasProjeController {
    private HasProjeService hasProjeService;

    public HasProjeController(HasProjeService hasProjeService) {
        this.hasProjeService = hasProjeService;
    }
    @GetMapping
    public List<HasProje> findAllbyId(){
        return hasProjeService.findAll();
    }

    @PostMapping
    public HasProje saveHasProje(@RequestBody HasProje hasProje){
        return hasProjeService.kaydetHasProje(hasProje);
    }
    @PutMapping
    public HasProje updateHasProje(@RequestBody HasProje hasProje){
        return hasProjeService.guncelleHasProje(hasProje);
    }
    @DeleteMapping("/{id}")
    public void deleteHasProje(@PathVariable("id") Long id){
        hasProjeService.silHasProje(id);
    }
}
