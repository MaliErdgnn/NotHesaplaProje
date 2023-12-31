package com.example.demo.controller;

import com.example.demo.DTO.AuthenticationRequest;
import com.example.demo.DTO.AuthenticationResponse;
import com.example.demo.DTO.KullaniciDTO;
import com.example.demo.DTO.RegisterRequest;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.KullaniciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odev/kullanici")
@CrossOrigin
public class KullaniciController {
    private KullaniciService kullaniciService;
    private  AuthenticationService service;
    public KullaniciController(KullaniciService kullaniciService, AuthenticationService service) {
        this.kullaniciService = kullaniciService;
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PutMapping
    public AuthenticationResponse updateKullanici(@RequestBody KullaniciDTO kullanici){
        System.out.println("Kullanici controller = " + kullanici.toString());
        return kullaniciService.guncelleKullanici(kullanici);
    }
    @DeleteMapping("/sil/{email}")
    public void deleteKullanici(@PathVariable("email") String email){
        kullaniciService.silUser(email);
    }
}
