package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "harfhesap")
@Getter
@Setter
public class HarfHesap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hesapid")
    private Long hesapID;

    @Column(name = "dersad")
    private String dersAd;

    @Column(name = "tarih")
    private LocalDate tarih;

    @Column(name = "puan")
    private double puan;

    @Column(name = "vizeyuzde")
    private int vizeYuzde;

    @Column(name = "vizenot")
    private double vizeNot;

    @Column(name = "finalyuzde")
    private int finalYuzde;

    @Column(name = "finalnot")
    private double finalNot;

    @Column(name = "notsis")
    private String notSis;

    @Column(name = "harfsis")
    private String harfSIS;

    @Column(name = "sinifort")
    private double sinifOrt;

    @Column(name = "odevsy")
    private int odevSy;

    @Column(name = "odevyuzde")
    private int odevYuzde;

    @Column(name = "quizsy")
    private int quizSy;

    @Column(name = "quizyuzde")
    private int quizYuzde;

    @Column(name = "labsy")
    private int labSy;

    @Column(name = "labyuzde")
    private int labYuzde;

    @Column(name = "projesy")
    private int projeSy;

    @Column(name = "projeyuzde")
    private int projeYuzde;

    @Column(name = "harfnot")
    private String harfNot;

    public HarfHesap(Long hesapID, String dersAd, LocalDate tarih, double puan, int vizeYuzde, double vizeNot, int finalYuzde, double finalNot, String notSis, String harfSIS, double sinifOrt, int odevSy, int odevYuzde, int quizSy, int quizYuzde, int labSy, int labYuzde, int projeSy, int projeYuzde, String harfNot) {
        this.hesapID = hesapID;
        this.dersAd = dersAd;
        this.tarih = tarih;
        this.puan = puan;
        this.vizeYuzde = vizeYuzde;
        this.vizeNot = vizeNot;
        this.finalYuzde = finalYuzde;
        this.finalNot = finalNot;
        this.notSis = notSis;
        this.harfSIS = harfSIS;
        this.sinifOrt = sinifOrt;
        this.odevSy = odevSy;
        this.odevYuzde = odevYuzde;
        this.quizSy = quizSy;
        this.quizYuzde = quizYuzde;
        this.labSy = labSy;
        this.labYuzde = labYuzde;
        this.projeSy = projeSy;
        this.projeYuzde = projeYuzde;
        this.harfNot = harfNot;
    }

    public HarfHesap(String dersAd, LocalDate tarih, double puan, int vizeYuzde, double vizeNot, int finalYuzde, double finalNot, String notSis, String harfSIS, double sinifOrt, int odevSy, int odevYuzde, int quizSy, int quizYuzde, int labSy, int labYuzde, int projeSy, int projeYuzde, String harfNot) {
        this.dersAd = dersAd;
        this.tarih = tarih;
        this.puan = puan;
        this.vizeYuzde = vizeYuzde;
        this.vizeNot = vizeNot;
        this.finalYuzde = finalYuzde;
        this.finalNot = finalNot;
        this.notSis = notSis;
        this.harfSIS = harfSIS;
        this.sinifOrt = sinifOrt;
        this.odevSy = odevSy;
        this.odevYuzde = odevYuzde;
        this.quizSy = quizSy;
        this.quizYuzde = quizYuzde;
        this.labSy = labSy;
        this.labYuzde = labYuzde;
        this.projeSy = projeSy;
        this.projeYuzde = projeYuzde;
        this.harfNot = harfNot;
    }

    public HarfHesap() {

    }
}
