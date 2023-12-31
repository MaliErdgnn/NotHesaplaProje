package com.example.demo.repository;
import com.example.demo.entity.OrtHesap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrtHesapRepository extends JpaRepository<OrtHesap, Long> {

}