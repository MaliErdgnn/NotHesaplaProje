package com.example.demo.DTO;


import java.util.List;

public class OrtHesaplayici {
   private Long ortId;
   private int eskiKredi;
   private int dersSayisi;
   private double gno;
   private String harfSis;
   private List<DersDTO> dersList;

   public OrtHesaplayici(Long ortId, int eskiKredi, int dersSayisi, double gno, String harfSis, List<DersDTO> dersList) {
      this.ortId = ortId;
      this.eskiKredi = eskiKredi;
      this.dersSayisi = dersSayisi;
      this.gno = gno;
      this.harfSis = harfSis;
      this.dersList = dersList;
   }

   public OrtHesaplayici() {

   }

   public int getEskiKredi() {
      return eskiKredi;
   }

   public void setEskiKredi(int eskiKredi) {
      this.eskiKredi = eskiKredi;
   }

   public int getDersSayisi() {
      return dersSayisi;
   }

   public void setDersSayisi(int dersSayisi) {
      this.dersSayisi = dersSayisi;
   }

   public double getGno() {
      return gno;
   }

   public Long getId() {
      return ortId;
   }

   public void setId(Long ortId) {
      this.ortId = ortId;
   }

   public void setGno(double gno) {
      this.gno = gno;
   }

   public String getHarfSis() {
      return harfSis;
   }

   public void setHarfSis(String harfSis) {
      this.harfSis = harfSis;
   }

   public List<DersDTO> getDersList() {
      return dersList;
   }

   public void setDersList(List<DersDTO> dersList) {
      this.dersList = dersList;
   }
}
