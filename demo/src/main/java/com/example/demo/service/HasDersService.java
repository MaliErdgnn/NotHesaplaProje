package com.example.demo.service;

import com.example.demo.entity.HasDers;
import com.example.demo.repository.HasDersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasDersService {


    @Autowired
    private HasDersRepository hasDersRepository;

    public List<HasDers> findAll(){
        return hasDersRepository.findAll();
    }

    public HasDers kaydet(HasDers hasDers){
        return hasDersRepository.save(hasDers);
    }

    public HasDers guncelle(HasDers hasDers){
        return hasDersRepository.save(hasDers);
    }

    public void sil(Long id){
        hasDersRepository.deleteById(id);
    }
}
