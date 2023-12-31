package com.example.demo.repository;
import com.example.demo.entity.HasDers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HasDersRepository extends JpaRepository<HasDers, Long> {
}
