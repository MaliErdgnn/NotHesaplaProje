package com.example.demo.DTO;

public class DersDTO {
    private String dersAdi;
    private int kredi;
    private String not;

    public DersDTO(String dersAdi, int kredi, String not) {
        this.dersAdi = dersAdi;
        this.kredi = kredi;
        this.not = not;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getKredi() {
        return kredi;
    }

    public void setKredi(int kredi) {
        this.kredi = kredi;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }
}
