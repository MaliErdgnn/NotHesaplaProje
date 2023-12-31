package com.example.demo.controller;

import com.example.demo.DTO.DersDTO;
import com.example.demo.entity.Ders;
import com.example.demo.entity.HasDers;
import com.example.demo.service.DersService;
import com.example.demo.service.HasDersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odev/hasders")
@CrossOrigin
public class HasDersController {
    public final HasDersService hasDersService;
    public HasDersController(HasDersService hasDersService) {
        this.hasDersService = hasDersService;
    }

    @GetMapping
    public List<HasDers> findAllbyId(){
        return hasDersService.findAll();
    }

    @PostMapping
    public HasDers saveHasDers(@RequestBody HasDers hasDers){
        return hasDersService.kaydet(hasDers);
    }
    @PutMapping
    public HasDers updateHasDers(@RequestBody HasDers hasDers){
        return hasDersService.guncelle(hasDers);
    }
    @DeleteMapping("/{id}")
    public void deleteHasDers(@PathVariable("id") Long id){
        hasDersService.sil(id);
    }
}
