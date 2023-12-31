package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.lang.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orthesap")
@Getter
@Setter
public class OrtHesap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ortid")
    private Long ortID;

    @Column(name = "gno")//, precision = 3, scale = 2)
    private double gno;

    @Column(name = "yenigno")//, precision = 3, scale = 2)
    private double yeniGno;

    @Column(name = "donemort")//, precision = 3, scale = 2)
    private double donemOrt;

    @Column(name = "harfsis")
    private String harfSis;

    @Column(name = "derssy")
    private int dersSy;

    @Column(name = "eskikredi")
    private int eskiKredi;

    @Column(name = "datee")
    private LocalDate  date;

    public OrtHesap(Long ortID, double gno, double yeniGno, double donemOrt, String harfSis, int dersSy, int eskiKredi, LocalDate date) {
        this.ortID = ortID;
        this.gno = gno;
        this.yeniGno = yeniGno;
        this.donemOrt = donemOrt;
        this.harfSis = harfSis;
        this.dersSy = dersSy;
        this.eskiKredi = eskiKredi;
        this.date = date;
    }
    public OrtHesap(){

    }

    public OrtHesap(double gno, double yeniGno, double donemOrt, String harfSis, int dersSy, int eskiKredi, LocalDate date) {
        this.gno = gno;
        this.yeniGno = yeniGno;
        this.donemOrt = donemOrt;
        this.harfSis = harfSis;
        this.dersSy = dersSy;
        this.eskiKredi = eskiKredi;
        this.date = date;
    }
}
