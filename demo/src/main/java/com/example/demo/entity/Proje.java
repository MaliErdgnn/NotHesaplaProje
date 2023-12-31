package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "proje")
@Getter
@Setter
public class Proje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeid")
    private Long projeID;

    @Column(name = "projenot")//, precision = 5, scale = 2)
    private double  projeNot;

    public Proje(Long projeID, double projeNot) {
        this.projeID = projeID;
        this.projeNot = projeNot;
    }
    public Proje(double projeNot) {
        this.projeNot = projeNot;
    }public Proje() {

    }
}
