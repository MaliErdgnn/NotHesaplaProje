package com.example.demo.service;

import com.example.demo.AuthConfig.JwtService;
import com.example.demo.DTO.AuthenticationRequest;
import com.example.demo.DTO.AuthenticationResponse;
import com.example.demo.DTO.KullaniciDTO;
import com.example.demo.DTO.RegisterRequest;
import com.example.demo.entity.Kullanici;
import com.example.demo.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService {
    @Autowired
    KullaniciRepository kullaniciRepository;

@Autowired
    PasswordEncoder passwordEncoder;
@Autowired
     JwtService jwtService;
@Autowired
    AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Kullanici.builder()
                .ad(request.getAd())
                .soyad(request.getSoyad())
                .email(request.getEmail())
                .sifre(passwordEncoder.encode(request.getSifre()))
                .build();
        kullaniciRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().email(user.getEmail()).sifre(user.getSifre()).ad(user.getAd()).soyad(user.getSoyad()).token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSifre()));
        var user = kullaniciRepository.findById(request.getEmail()).orElseThrow();
        System.out.println(user.toString());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().email(user.getEmail()).sifre(user.getSifre()).ad(user.getAd()).soyad(user.getSoyad()).token(jwtToken).build();
    }

    public void silUser(String email){
        kullaniciRepository.deleteById(email);
    }

    public AuthenticationResponse guncelleKullanici(KullaniciDTO kullanici){
        System.out.println("Kullanici service = " + kullanici.toString());
        kullaniciRepository.updateByEmail(kullanici.getEmail().toString(), kullanici.getNewEmail().toString(), kullanici.getAd(), kullanici.getSoyad(), passwordEncoder.encode(kullanici.getSifre()));
        var user = kullaniciRepository.findById(kullanici.getNewEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().email(kullanici.getEmail()).sifre(kullanici.getSifre()).ad(kullanici.getAd()).soyad(kullanici.getSoyad()).token(jwtToken).build();
    }

}
