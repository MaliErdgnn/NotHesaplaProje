package com.example.demo.controller2;

import com.example.demo.entity.HasHarfHesap;
import com.example.demo.entity.HasOrtHesap;
import com.example.demo.service2.HasHarfHesapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odev/hasharfhesap")
@CrossOrigin
public class HasHarfHesapController {
    private HasHarfHesapService hasHarfHesapService;

    public HasHarfHesapController(HasHarfHesapService hasHarfHesapService) {
        this.hasHarfHesapService = hasHarfHesapService;
    }
    @GetMapping
    public List<HasHarfHesap> findAllbyId(){
        return hasHarfHesapService.findAll();
    }

    @PostMapping
    public HasHarfHesap saveHasHarfHesap(@RequestBody HasHarfHesap hasHarfHesap){
        return hasHarfHesapService.kaydetHasHarfHesap(hasHarfHesap);
    }
    @PutMapping
    public HasHarfHesap updateHasHarfHesap(@RequestBody HasHarfHesap hasHarfHesap){
        return hasHarfHesapService.guncelleHasHarfHesap(hasHarfHesap);
    }
    @DeleteMapping("/{id}")
    public void deletehasHarfHesap(@PathVariable("id") Long id){
        hasHarfHesapService.silHasHarfHesap(id);
    }
}
