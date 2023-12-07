package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ders")
@Getter
@Setter
public class ders {

    @Id
    @Column(name = "dersAdi")
    private String dersAdi;

    @Column(name = "kredi")
    private int kredi;

    @Column(name = "harfNotu")
    private String harfNotu;


}

