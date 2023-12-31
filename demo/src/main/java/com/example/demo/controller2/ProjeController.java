package com.example.demo.controller2;

import com.example.demo.entity.Odev;
import com.example.demo.entity.Proje;
import com.example.demo.service2.ProjeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odev/proje")
@CrossOrigin
public class ProjeController {
    private ProjeService projeService;

    public ProjeController(ProjeService projeService) {
        this.projeService = projeService;
    }
    @GetMapping("/{id}")
    public Optional<Proje> getProje(@PathVariable("id") Long id){
        return projeService.getById(id);
    }
    @PostMapping
    public Proje saveProje(@RequestBody Proje proje){
        return projeService.kaydet(proje);
    }
    @PutMapping
    public Proje updateProje(@RequestBody Proje proje){
        return projeService.guncelle(proje);
    }
    @DeleteMapping("/{id}")
    public void deleteProje(@PathVariable("id") Long id){
        projeService.silProje(id);
    }
}
