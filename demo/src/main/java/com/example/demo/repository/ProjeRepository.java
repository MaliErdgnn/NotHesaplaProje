package com.example.demo.repository;

import com.example.demo.entity.Proje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjeRepository extends JpaRepository<Proje, Long> {
}
