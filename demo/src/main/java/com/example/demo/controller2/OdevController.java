package com.example.demo.controller2;

import com.example.demo.entity.Lab;
import com.example.demo.entity.Odev;
import com.example.demo.service.DersService;
import com.example.demo.service2.OdevService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odev/odev")
@CrossOrigin
public class OdevController {
    private OdevService odevService;
    public OdevController(OdevService odevService){
        this.odevService = odevService;
    }
    @GetMapping("/{id}")
    public Optional<Odev> getOdev(@PathVariable("id") Long id){
        return odevService.getById(id);
    }
    @PostMapping
    public Odev saveOdev(@RequestBody Odev odev){
        return odevService.kaydet(odev);
    }
    @PutMapping
    public Odev updateOdev(@RequestBody Odev odev){
        return odevService.guncelle(odev);
    }
    @DeleteMapping("/{id}")
    public void deleteOdev(@PathVariable("id") Long id){
        odevService.silOdev(id);
    }
}
