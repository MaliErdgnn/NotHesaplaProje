package com.example.demo.controller;
import com.example.demo.DTO.DersDTO;
import com.example.demo.entity.Ders;
import com.example.demo.service.DersService;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odev/ders")
@CrossOrigin
public class DersController {
    private final DersService dersService;

    public DersController(DersService dersService) {
        this.dersService = dersService;
    }

    @GetMapping("/{id}")
    public Optional<Ders> getDers(@PathVariable("id") Long id){
        return dersService.getById(id);
    }
    @PostMapping
    public Ders saveDers(@RequestBody DersDTO dersDTO){
        return dersService.kaydet(dersDTO);
    }
    @PutMapping
    public Ders updateDers(@RequestBody Ders ders){
        return dersService.guncelle(ders);
    }
    @DeleteMapping("/{id}")
    public void deleteDers(@PathVariable("id") Long id){
        dersService.sil(id);
    }
}
