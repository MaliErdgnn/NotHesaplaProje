package com.example.demo.service2;

import com.example.demo.entity.HasLab;
import com.example.demo.repository.HasLabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasLabService {
    @Autowired
    private HasLabRepository hasLabRepository;

    public List<HasLab> findAll(){
        return hasLabRepository.findAll();
    }
    public HasLab kaydetHasLab(HasLab hasLab){
        return hasLabRepository.save(hasLab);
    }
    public HasLab guncelleHasLab(HasLab hasLab){
        return hasLabRepository.save(hasLab);
    }
    public void silHasLab(Long id){
        hasLabRepository.deleteById(id);
    }
}
