package com.example.demo.repository;
import com.example.demo.entity.Kullanici;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, String> {

    @Modifying
    @Transactional
    @Query("UPDATE Kullanici k SET k.email = :newEmail, k.ad = :newAd, k.soyad = :newSoyad, k.sifre = :newSifre WHERE k.email = :oldEmail")
    int updateByEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail, @Param("newAd") String newAd, @Param("newSoyad") String newSoyad, @Param("newSifre") String newSifre);

   // Optional<Kullanici> findByEmail(String email);

    @Query("SELECT k FROM Kullanici k WHERE k.email = :userid AND k.sifre = :sifre")
    Optional<Kullanici> getKullaniciByEmailSifre(@Param("userid") String email, @Param("sifre") String sifre);
}