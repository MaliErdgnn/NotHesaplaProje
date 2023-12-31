package com.example.demo.service;
import com.example.demo.DTO.OrtHesaplayici;
import com.example.demo.DTO.DersDTO;
import com.example.demo.entity.Ders;
import com.example.demo.entity.HasDers;
import com.example.demo.entity.OrtHesap;
import com.example.demo.repository.DersRepository;
import com.example.demo.repository.HasDersRepository;
import com.example.demo.repository.OrtHesapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrtHesapService {

    @Autowired
    private OrtHesapRepository ortHesapRepository;



    public OrtHesapService(OrtHesapRepository ortHesapRepository) {
        this.ortHesapRepository = ortHesapRepository;
    }

    public OrtHesap hesaplaVeKaydet(OrtHesaplayici ortHesaplayici) {
        double dersOrtalamasi = calculateDonemOrtalamasi(ortHesaplayici);

        double genelNotOrt = calculateGenelNotOrtalamasi(ortHesaplayici);



        OrtHesap yeniOrtHesap = new OrtHesap(ortHesaplayici.getGno(), genelNotOrt, dersOrtalamasi, ortHesaplayici.getHarfSis(), ortHesaplayici.getDersSayisi(),ortHesaplayici.getEskiKredi(),LocalDate.now());

        return ortHesapRepository.save(yeniOrtHesap);

    }


    public OrtHesap guncelleVeKaydet(OrtHesaplayici ortHesaplayici) {

        double dersOrtalamasi = calculateDonemOrtalamasi(ortHesaplayici);

        double genelNotOrt = calculateGenelNotOrtalamasi(ortHesaplayici);



        OrtHesap yeniOrtHesap = new OrtHesap(ortHesaplayici.getId(),ortHesaplayici.getGno(), genelNotOrt, dersOrtalamasi, ortHesaplayici.getHarfSis(), ortHesaplayici.getDersSayisi(),ortHesaplayici.getEskiKredi(),LocalDate.now());

        ortHesapRepository.save(yeniOrtHesap);
        return yeniOrtHesap;
    }

    public void sil(Long id){
        ortHesapRepository.deleteById(id);
    }
    public double calculateDonemOrtalamasi(OrtHesaplayici ortHesap) {
        int toplamKredi = 0;
        double toplamPuan = 0;

        for (DersDTO ders : ortHesap.getDersList()) {
            String dersAdi = ders.getDersAdi();
            int kredi = ders.getKredi();
            String harfNotu = ders.getNot();

            double score = convertHarfNotuToPuan(ortHesap,harfNotu);
            toplamPuan += kredi * score;

            toplamKredi += kredi;
        }
        double donemOrt = 0;
        if(toplamKredi != 0){
            donemOrt = toplamPuan / toplamKredi;
        }



        return donemOrt;
    }

    private double convertHarfNotuToPuan(OrtHesaplayici ortHesap, String harfNotu) {

        if ("option1".equalsIgnoreCase(ortHesap.getHarfSis())) {
            if(Objects.equals(harfNotu, "AA"))
                return 4.0;
            else if(Objects.equals(harfNotu, "BA"))
                return 3.5;
            else if(Objects.equals(harfNotu, "BB"))
                return 3.0;
            else if(Objects.equals(harfNotu, "CB"))
                return 2.5;
            else if(Objects.equals(harfNotu, "CC"))
                return 2.0;
            else if(Objects.equals(harfNotu, "DC"))
                return 1.5;
            else if(Objects.equals(harfNotu, "DD"))
                return 1.0;
            else
                return 0.0;
        }
        else if ("option2".equalsIgnoreCase(ortHesap.getHarfSis())) {
            if(Objects.equals(harfNotu, "AA"))
                return 4.0;
            else if(Objects.equals(harfNotu, "AB"))
                return 3.7;
            else if(Objects.equals(harfNotu, "BA"))
                return 3.3;
            else if(Objects.equals(harfNotu, "BB"))
                return 3.0;
            else if(Objects.equals(harfNotu, "BC"))
                return 2.7;
            else if(Objects.equals(harfNotu, "CB"))
                return 2.3;
            else if(Objects.equals(harfNotu, "CC"))
                return 2.0;
            else if(Objects.equals(harfNotu, "CD"))
                return 1.7;
            else if(Objects.equals(harfNotu, "DC"))
                return 1.3;
            else if(Objects.equals(harfNotu, "DD"))
                return 1.0;
            else
                return 0.0;
        }
        else if ("option3".equalsIgnoreCase(ortHesap.getHarfSis())) {
            if(Objects.equals(harfNotu, "A"))
                return 4.0;
            else if(Objects.equals(harfNotu, "A-"))
                return 3.7;
            else if(Objects.equals(harfNotu, "B+"))
                return 3.3;
            else if(Objects.equals(harfNotu, "B"))
                return 3.0;
            else if(Objects.equals(harfNotu, "B-"))
                return 2.7;
            else if(Objects.equals(harfNotu, "C+"))
                return 2.3;
            else if(Objects.equals(harfNotu, "C"))
                return 2.0;
            else if(Objects.equals(harfNotu, "C-"))
                return 1.7;
            else if(Objects.equals(harfNotu, "D+"))
                return 1.3;
            else if(Objects.equals(harfNotu, "D"))
                return 1.0;
            else
                return 0.0;
        }
        return -1;
    }


    private double calculateGenelNotOrtalamasi(OrtHesaplayici ortHesap) {

        int toplamKredi = 0;
        double toplamPuan = 0;
        int eskiKredi = ortHesap.getEskiKredi();
        double ggno = ortHesap.getGno();
        for (DersDTO ders : ortHesap.getDersList()) {
            String dersAdi = ders.getDersAdi();
            int kredi = ders.getKredi();
            String harfNotu = ders.getNot();

            double score = convertHarfNotuToPuan(ortHesap,harfNotu);
            System.out.println("Score = " + score);
            toplamPuan += kredi * score;

            toplamKredi += kredi;
        }
        double donemOrt = 0;
        if(toplamKredi != 0){
            donemOrt = toplamPuan / toplamKredi;
        }
        double yeniGno = 0;
        if((toplamKredi + eskiKredi) != 0){
            yeniGno = ((donemOrt * toplamKredi) + (ggno * eskiKredi)) / (toplamKredi + eskiKredi);
        }

        return yeniGno;
    }


    public List<OrtHesap> getOrtHesap() {
        return ortHesapRepository.findAll();
    }

    public Optional<OrtHesap> getOrtHesapById(Long id) {
        return ortHesapRepository.findById(id);
    }
}


