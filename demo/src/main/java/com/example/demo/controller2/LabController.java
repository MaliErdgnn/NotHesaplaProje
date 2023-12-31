package com.example.demo.controller2;

import com.example.demo.DTO.DersDTO;
import com.example.demo.entity.Ders;
import com.example.demo.entity.Lab;
import com.example.demo.service2.LabService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odev/lab")
@CrossOrigin
public class LabController {
    private LabService labService;
    public LabController(LabService labService){
        this.labService = labService;
    }
    @GetMapping("/{id}")
    public Optional<Lab> getLab(@PathVariable("id") Long id){
        return labService.getById(id);
    }
    @PostMapping
    public Lab saveLab(@RequestBody Lab lab){
        return labService.kaydet(lab);
    }
    @PutMapping
    public Lab updateLab(@RequestBody Lab lab){
        return labService.guncelle(lab);
    }
    @DeleteMapping("/{id}")
    public void deleteLab(@PathVariable("id") Long id){
        labService.silLab(id);
    }
}
