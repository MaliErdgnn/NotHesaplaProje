package com.example.demo.controller;
import com.example.demo.DTO.OrtHesaplayici;
import com.example.demo.entity.OrtHesap;
import com.example.demo.service.OrtHesapService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odev/orthesap")
@CrossOrigin
public class OrtHesapController {
    private final OrtHesapService ortHesapService;

    public OrtHesapController(OrtHesapService ortHesapService) {
        this.ortHesapService = ortHesapService;
    }

    @GetMapping
    public List<OrtHesap> getOrtHesap(){
        return ortHesapService.getOrtHesap();
    }
    @GetMapping("/{id}")
    public Optional<OrtHesap> getOrtHesapById(@PathVariable("id") Long id){
        return ortHesapService.getOrtHesapById(id);
    }
    @PostMapping
    public OrtHesap saveOrtHesap(@RequestBody OrtHesaplayici ortHesaplayici){
        return ortHesapService.hesaplaVeKaydet(ortHesaplayici);
    }
    @PutMapping
    public OrtHesap updateHesap(@RequestBody OrtHesaplayici ortHesaplayici){
        return ortHesapService.guncelleVeKaydet(ortHesaplayici);
    }
    @DeleteMapping("/{id}")
    public void deleteHesap(@PathVariable("id") Long id){
         ortHesapService.sil(id);
    }
}
