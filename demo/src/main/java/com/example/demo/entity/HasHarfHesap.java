package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasharfhesap")
@Getter
@Setter
public class HasHarfHesap {
    @Id
    @Column(name = "hesapid")
    private Long hesapID;


    @Column(name = "email")
    private String email;

    public HasHarfHesap(Long hesapID, String email) {
        this.hesapID = hesapID;
        this.email = email;
    }

    public HasHarfHesap() {

    }
}
