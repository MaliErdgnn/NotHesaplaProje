package com.example.demo.service2;

import com.example.demo.entity.Proje;
import com.example.demo.repository.ProjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjeService {
    @Autowired
    private ProjeRepository projeRepository;

    public Proje kaydet(Proje proje){
        return projeRepository.save(proje);
    }

    public Proje guncelle(Proje proje){
        return projeRepository.save(proje);
    }
    public void silProje(Long id){
        projeRepository.deleteById(id);
    }
    public Optional<Proje> getById(Long id){
        return projeRepository.findById(id);
    }
}
