package com.example.demo.repository;
import com.example.demo.entity.HasDers;
import com.example.demo.entity.HasOrtHesap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HasOrtHesapRepository extends JpaRepository<HasOrtHesap, Long> {
}
