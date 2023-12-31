package com.example.demo.repository;
import com.example.demo.entity.HarfHesap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarfHesapRepository extends JpaRepository<HarfHesap, Long> {

}
