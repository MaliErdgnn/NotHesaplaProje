package com.example.demo.service2;

import com.example.demo.entity.Odev;
import com.example.demo.repository.OdevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OdevService {
    @Autowired
    private OdevRepository odevRepository;

    public Odev kaydet(Odev odev){
        return odevRepository.save(odev);
    }

    public Odev guncelle(Odev odev){
        return odevRepository.save(odev);
    }
    public void silOdev (Long id){
        odevRepository.deleteById(id);
    }
    public Optional<Odev> getById(Long id){
        return odevRepository.findById(id);
    }
}
