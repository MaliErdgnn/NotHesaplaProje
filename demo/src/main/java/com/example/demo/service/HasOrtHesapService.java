package com.example.demo.service;

import com.example.demo.entity.HasOrtHesap;
import com.example.demo.repository.HasOrtHesapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasOrtHesapService {
    @Autowired
    private HasOrtHesapRepository hasOrtHesapRepository;
    public List<HasOrtHesap> findAll() {
        return hasOrtHesapRepository.findAll();
    }

    public HasOrtHesap kaydet(HasOrtHesap hasOrtHesap) {
        return hasOrtHesapRepository.save(hasOrtHesap);
    }

    public HasOrtHesap guncelle(HasOrtHesap hasOrtHesap) {
        return hasOrtHesapRepository.save(hasOrtHesap);

    }

    public void sil(Long id) {
        hasOrtHesapRepository.deleteById(id);
    }
}
