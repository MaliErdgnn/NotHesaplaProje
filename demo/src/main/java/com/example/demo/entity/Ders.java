package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ders")
@Getter
@Setter
public class Ders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dersid")
    private Long dersID;

    @Column(name = "dersadi")
    private String dersAdi;

    @Column(name = "kredi")
    private int kredi;

    @Column(name = "harfnotu")
    private String harfNotu;

    public Ders(Long dersID, String dersAdi, int kredi, String harfNotu) {
        this.dersID = dersID;
        this.dersAdi = dersAdi;
        this.kredi = kredi;
        this.harfNotu = harfNotu;
    }

    public Ders() {
    }

    public Ders(String dersAdi, int kredi, String harfNotu) {
        this.dersAdi = dersAdi;
        this.kredi = kredi;
        this.harfNotu = harfNotu;
    }
}

