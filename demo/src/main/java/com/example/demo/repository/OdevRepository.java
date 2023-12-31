package com.example.demo.repository;
import com.example.demo.entity.Odev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdevRepository extends JpaRepository<Odev, Long> {
}
