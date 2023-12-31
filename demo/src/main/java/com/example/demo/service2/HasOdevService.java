package com.example.demo.service2;

import com.example.demo.entity.HasOdev;
import com.example.demo.repository.HasOdevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasOdevService {
    @Autowired
    private HasOdevRepository hasOdevRepository;

    public List<HasOdev> findAll(){
        return hasOdevRepository.findAll();
    }
    public HasOdev kaydetHasOdev(HasOdev hasOdev){
        return hasOdevRepository.save(hasOdev);
    }
    public HasOdev guncelleHasOdev(HasOdev hasOdev){
        return hasOdevRepository.save(hasOdev);
    }
    public void silHasOdev(Long id){
        hasOdevRepository.deleteById(id);
    }
}
