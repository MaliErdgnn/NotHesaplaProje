package com.example.demo.service2;

import com.example.demo.entity.HasProje;
import com.example.demo.repository.HasProjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasProjeService {
    @Autowired
    private HasProjeRepository hasProjeRepository;

    public List<HasProje> findAll(){
        return hasProjeRepository.findAll();
    }
    public HasProje kaydetHasProje(HasProje hasProje){
        return hasProjeRepository.save(hasProje);
    }
    public HasProje guncelleHasProje(HasProje hasProje){
        return hasProjeRepository.save(hasProje);
    }
    public void silHasProje(Long id){
        hasProjeRepository.deleteById(id);
    }
}
