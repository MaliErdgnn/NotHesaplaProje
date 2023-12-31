package com.example.demo.service2;

import com.example.demo.entity.Lab;
import com.example.demo.repository.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class LabService {

    @Autowired
    private LabRepository labRepository;

    public Lab kaydet(Lab lab){
        return labRepository.save(lab);
    }

    public Lab guncelle(Lab lab){
        return labRepository.save(lab);
    }

    public void silLab(Long id){
        labRepository.deleteById(id);
    }

    public Optional<Lab> getById(Long id){
        return labRepository.findById(id);
    }
}
