package com.example.demo.service2;

import com.example.demo.entity.HasHarfHesap;
import com.example.demo.repository.HasHarfHesapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasHarfHesapService {
    @Autowired
    private HasHarfHesapRepository hasHarfHesapRepository;

    public List<HasHarfHesap> findAll(){
        return hasHarfHesapRepository.findAll();
    }
    public HasHarfHesap kaydetHasHarfHesap(HasHarfHesap hasHarfHesap){
        return hasHarfHesapRepository.save(hasHarfHesap);
    }
    public HasHarfHesap guncelleHasHarfHesap(HasHarfHesap hasHarfHesap){
        return hasHarfHesapRepository.save(hasHarfHesap);
    }
    public void silHasHarfHesap(Long id){
        hasHarfHesapRepository.deleteById(id);
    }
}
