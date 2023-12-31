package com.example.demo.DTO;

import com.example.demo.entity.Lab;
import com.example.demo.entity.Odev;
import com.example.demo.entity.Proje;
import com.example.demo.entity.Quiz;

import java.time.LocalDate;
import java.util.List;

public class HarfHesaplayici {
    private Long hesapID;
    private String dersAd;
    private int vizeYuzde;
    private double vizeNot;
    private int finalYuzde;
    private double finalNot;
    private String notSis;
    private String harfSIS;
    private double sinifOrt;
    private int odevSy;
    private int odevYuzde;
    private int quizSy;
    private int quizYuzde;
    private int labSy;
    private int labYuzde;
    private int projeSy;
    private int projeYuzde;
    private List<Quiz> quizList;
    private List<Odev> odevList;
    private List<Proje> projeList;
    private List<Lab> labList;

    public HarfHesaplayici(Long hesapID, String dersAd, int vizeYuzde, double vizeNot, int finalYuzde, double finalNot, String notSis, String harfSIS, double sinifOrt, int odevSy, int odevYuzde, int quizSy, int quizYuzde, int labSy, int labYuzde, int projeSy, int projeYuzde, List<Quiz> quizList, List<Odev> odevList, List<Proje> projeList, List<Lab> labList) {
        this.hesapID = hesapID;
        this.dersAd = dersAd;
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
        this.quizList = quizList;
        this.odevList = odevList;
        this.projeList = projeList;
        this.labList = labList;
    }
    public HarfHesaplayici(Long hesapID, String dersAd, int vizeYuzde, double vizeNot, int finalYuzde, double finalNot, String notSis, String harfSIS, int odevSy, int odevYuzde, int quizSy, int quizYuzde, int labSy, int labYuzde, int projeSy, int projeYuzde, List<Quiz> quizList, List<Odev> odevList, List<Proje> projeList, List<Lab> labList) {
        this.hesapID = hesapID;
        this.dersAd = dersAd;
        this.vizeYuzde = vizeYuzde;
        this.vizeNot = vizeNot;
        this.finalYuzde = finalYuzde;
        this.finalNot = finalNot;
        this.notSis = notSis;
        this.harfSIS = harfSIS;
        this.odevSy = odevSy;
        this.odevYuzde = odevYuzde;
        this.quizSy = quizSy;
        this.quizYuzde = quizYuzde;
        this.labSy = labSy;
        this.labYuzde = labYuzde;
        this.projeSy = projeSy;
        this.projeYuzde = projeYuzde;
        this.quizList = quizList;
        this.odevList = odevList;
        this.projeList = projeList;
        this.labList = labList;
    }
    public HarfHesaplayici(){
    }

    public Long getHesapID() {
        return hesapID;
    }

    public void setHesapID(Long hesapID) {
        this.hesapID = hesapID;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }





    public int getVizeYuzde() {
        return vizeYuzde;
    }

    public void setVizeYuzde(int vizeYuzde) {
        this.vizeYuzde = vizeYuzde;
    }

    public double getVizeNot() {
        return vizeNot;
    }

    public void setVizeNot(double vizeNot) {
        this.vizeNot = vizeNot;
    }

    public int getFinalYuzde() {
        return finalYuzde;
    }

    public void setFinalYuzde(int finalYuzde) {
        this.finalYuzde = finalYuzde;
    }

    public double getFinalNot() {
        return finalNot;
    }

    public void setFinalNot(double finalNot) {
        this.finalNot = finalNot;
    }

    public String getNotSis() {
        return notSis;
    }

    public void setNotSis(String notSis) {
        this.notSis = notSis;
    }

    public String getHarfSIS() {
        return harfSIS;
    }

    public void setHarfSIS(String harfSIS) {
        this.harfSIS = harfSIS;
    }

    public double getSinifOrt() {
        return sinifOrt;
    }

    public void setSinifOrt(double sinifOrt) {
        this.sinifOrt = sinifOrt;
    }

    public int getOdevSy() {
        return odevSy;
    }

    public void setOdevSy(int odevSy) {
        this.odevSy = odevSy;
    }

    public int getOdevYuzde() {
        return odevYuzde;
    }

    public void setOdevYuzde(int odevYuzde) {
        this.odevYuzde = odevYuzde;
    }

    public int getQuizSy() {
        return quizSy;
    }

    public void setQuizSy(int quizSy) {
        this.quizSy = quizSy;
    }

    public int getQuizYuzde() {
        return quizYuzde;
    }

    public void setQuizYuzde(int quizYuzde) {
        this.quizYuzde = quizYuzde;
    }

    public int getLabSy() {
        return labSy;
    }

    public void setLabSy(int labSy) {
        this.labSy = labSy;
    }

    public int getLabYuzde() {
        return labYuzde;
    }

    public void setLabYuzde(int labYuzde) {
        this.labYuzde = labYuzde;
    }

    public int getProjeSy() {
        return projeSy;
    }

    public void setProjeSy(int projeSy) {
        this.projeSy = projeSy;
    }

    public int getProjeYuzde() {
        return projeYuzde;
    }

    public void setProjeYuzde(int projeYuzde) {
        this.projeYuzde = projeYuzde;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public List<Odev> getOdevList() {
        return odevList;
    }

    public void setOdevList(List<Odev> odevList) {
        this.odevList = odevList;
    }

    public List<Proje> getProjeList() {
        return projeList;
    }

    public void setProjeList(List<Proje> projeList) {
        this.projeList = projeList;
    }

    public List<Lab> getLabList() {
        return labList;
    }

    public void setLabList(List<Lab> labList) {
        this.labList = labList;
    }
}
