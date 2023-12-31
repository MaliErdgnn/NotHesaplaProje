package com.example.demo.repository;
import com.example.demo.entity.HasOdev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HasOdevRepository extends JpaRepository<HasOdev, Long> {
}
