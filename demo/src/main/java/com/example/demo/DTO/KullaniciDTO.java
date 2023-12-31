package com.example.demo.DTO;



public class KullaniciDTO {

    private String email;

    private String newEmail;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    private String sifre;

    private String ad;

    private String soyad;

    public KullaniciDTO(String email, String sifre, String ad, String soyad) {
        this.email = email;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
    }
    public KullaniciDTO(String email, String newEmail, String sifre, String ad, String soyad) {
        this.email = email;
        this.newEmail = newEmail;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
    }
    public KullaniciDTO() {

    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "email='" + email + '\'' +
                ", newEmail='" + newEmail + '\'' +
                ", sifre='" + sifre + '\'' +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                '}';
    }
}
