package com.example.demo.controller;

import com.example.demo.entity.HasDers;
import com.example.demo.entity.HasOrtHesap;
import com.example.demo.repository.HasOrtHesapRepository;
import com.example.demo.service.HasDersService;
import com.example.demo.service.HasOrtHesapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odev/hasorthesap")
@CrossOrigin
public class HasOrtHesapController {
    public final HasOrtHesapService hasOrtHesapService;
    public HasOrtHesapController(HasOrtHesapService hasOrtHesapService) {
        this.hasOrtHesapService = hasOrtHesapService;
    }

    @GetMapping
    public List<HasOrtHesap> findAllbyId(){
        return hasOrtHesapService.findAll();
    }

    @PostMapping
    public HasOrtHesap saveHasOrtHesap(@RequestBody HasOrtHesap hasOrtHesap){
        return hasOrtHesapService.kaydet(hasOrtHesap);
    }
    @PutMapping
    public HasOrtHesap updateHasOrtHesap(@RequestBody HasOrtHesap hasOrtHesap){
        return hasOrtHesapService.guncelle(hasOrtHesap);
    }
    @DeleteMapping("/{id}")
    public void deleteHasOrtHesap(@PathVariable("id") Long id){
        hasOrtHesapService.sil(id);
    }
}
