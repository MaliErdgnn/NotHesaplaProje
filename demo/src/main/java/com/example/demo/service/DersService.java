package com.example.demo.service;

import com.example.demo.DTO.DersDTO;
import com.example.demo.entity.Ders;
import com.example.demo.repository.DersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DersService {
    @Autowired
    DersRepository dersRepository;

    public Ders kaydet(DersDTO dersDTO){
        Ders ders = new Ders(dersDTO.getDersAdi(), dersDTO.getKredi(), dersDTO.getNot());

        return dersRepository.save(ders);

    }
    public Ders guncelle(Ders ders){
        return dersRepository.save(ders);
    }
    public void sil(Long id){
        dersRepository.deleteById(id);
    }

    public Optional<Ders> getById(Long id) {
        return dersRepository.findById(id);
    }
}
