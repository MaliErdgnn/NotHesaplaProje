package com.example.demo.service;

import com.example.demo.AuthConfig.JwtService;
import com.example.demo.DTO.AuthenticationRequest;
import com.example.demo.DTO.AuthenticationResponse;
import com.example.demo.DTO.RegisterRequest;
import com.example.demo.entity.Kullanici;
import com.example.demo.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final KullaniciRepository kullaniciRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
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
}
