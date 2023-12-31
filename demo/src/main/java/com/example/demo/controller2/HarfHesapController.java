package com.example.demo.controller2;


import com.example.demo.DTO.HarfHesaplayici;
import com.example.demo.DTO.OrtHesaplayici;
import com.example.demo.entity.HarfHesap;
import com.example.demo.entity.OrtHesap;
import com.example.demo.service.OrtHesapService;
import com.example.demo.service2.HarfHesapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odev/harfhesap")
@CrossOrigin
public class HarfHesapController {
    private final HarfHesapService harfHesapService;

    public HarfHesapController(HarfHesapService harfHesapService) {
        this.harfHesapService = harfHesapService;
    }

    @GetMapping
    public List<HarfHesap> getHarfHesap(){
        return harfHesapService.getTumHarfHesapları();
    }
    @GetMapping("/{id}")
    public Optional<HarfHesap> getOrtHesapById(@PathVariable("id") Long id){
        return harfHesapService.getHarfHesapById(id);
    }
    @PostMapping
    public HarfHesap saveHarfHesap(@RequestBody HarfHesaplayici ortHesaplayici){
        return harfHesapService.hesaplaVeKaydet(ortHesaplayici);
    }
    @PutMapping
    public HarfHesap updateHarfHesap(@RequestBody HarfHesaplayici ortHesaplayici){
        return harfHesapService.hesaplaVeGuncelle(ortHesaplayici);
    }
    @DeleteMapping("/{id}")
    public void deleteHarfHesap(@PathVariable("id") Long id){
        harfHesapService.sil(id);
    }
}
