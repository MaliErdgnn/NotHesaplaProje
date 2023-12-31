package com.example.demo.service2;
import com.example.demo.DTO.HarfHesaplayici;
import com.example.demo.entity.*;
import com.example.demo.repository.HarfHesapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HarfHesapService {

    @Autowired
    private HarfHesapRepository harfHesapRepository;


    public static Date getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        return java.util.Date.from(localDate.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    public HarfHesap hesaplaVeKaydet(HarfHesaplayici harfHesap) {
        int quizOrt = 0;
        int odevOrt = 0;
        int projeOrt = 0;
        int labOrt = 0;
        String harfNotu = "";
        if(harfHesap.getQuizList() != null && harfHesap.getQuizList().size() != 0){
            for(Quiz quiz : harfHesap.getQuizList()){
                quizOrt += quiz.getQuizNot();
            }quizOrt = quizOrt / harfHesap.getQuizList().size();
        }
        if(harfHesap.getOdevList() != null && harfHesap.getOdevList().size() != 0){
            for(Odev odev : harfHesap.getOdevList()){
                odevOrt += odev.getOdevNot();
            }odevOrt = odevOrt / harfHesap.getOdevList().size();
        }
        if(harfHesap.getLabList() != null && harfHesap.getLabList().size() != 0){
            for(Lab lab : harfHesap.getLabList()){
                labOrt += lab.getLabNot();
            }labOrt = labOrt / harfHesap.getLabList().size();
        }
        if(harfHesap.getProjeList() != null && harfHesap.getProjeList().size() != 0){
            for(Proje proje : harfHesap.getProjeList()){
                projeOrt += proje.getProjeNot();
            }projeOrt = projeOrt / harfHesap.getProjeList().size();
        }


        double ort = (harfHesap.getVizeNot() * (harfHesap.getVizeYuzde() / 100.0)) +
                (harfHesap.getFinalNot() * (harfHesap.getFinalYuzde() / 100.0)) +
                (quizOrt * (harfHesap.getQuizYuzde() / 100.0)) +
                (odevOrt * (harfHesap.getOdevYuzde() / 100.0)) +
                (projeOrt * (harfHesap.getProjeYuzde() / 100.0)) +
                (labOrt * (harfHesap.getLabYuzde() / 100.0));



        double sinifOrtalama = harfHesap.getSinifOrt();

        if (Objects.equals(harfHesap.getNotSis(), "Katalog")) {
            harfNotu = katalogSistemiHarfNotuBelirle(ort, harfHesap);
        } else if (Objects.equals(harfHesap.getNotSis(), "Çan")) {
            harfNotu = canSistemiHarfNotuBelirle(ort, harfHesap.getSinifOrt(), harfHesap);
        }
        //harfHesap.setTarih(LocalDate.now());
        HarfHesap yeni = new HarfHesap(harfHesap.getDersAd(), LocalDate.now(), ort, harfHesap.getVizeYuzde(), harfHesap.getVizeNot(), harfHesap.getFinalYuzde(),harfHesap.getFinalNot(), harfHesap.getNotSis(), harfHesap.getHarfSIS(), harfHesap.getSinifOrt(), harfHesap.getOdevSy(), harfHesap.getOdevYuzde(), harfHesap.getQuizSy(), harfHesap.getQuizYuzde(), harfHesap.getLabSy(), harfHesap.getLabYuzde(), harfHesap.getProjeSy(), harfHesap.getProjeYuzde(), harfNotu );
        return harfHesapRepository.save(yeni);
    }
    public HarfHesap hesaplaVeGuncelle(HarfHesaplayici harfHesap) {
        int quizOrt = 0;
        int odevOrt = 0;
        int projeOrt = 0;
        int labOrt = 0;
        String harfNotu = "";
        if(harfHesap.getQuizList() != null && harfHesap.getQuizList().size() != 0){
            for(Quiz quiz : harfHesap.getQuizList()){
                quizOrt += quiz.getQuizNot();
            }quizOrt = quizOrt / harfHesap.getQuizList().size();
        }else{
        }
        if(harfHesap.getOdevList() != null  && harfHesap.getOdevList().size() != 0){
            for(Odev odev : harfHesap.getOdevList()){
                odevOrt += odev.getOdevNot();
            }odevOrt = odevOrt / harfHesap.getOdevList().size();
        }
        if(harfHesap.getLabList() != null  && harfHesap.getLabList().size() != 0){
            for(Lab lab : harfHesap.getLabList()){
                labOrt += lab.getLabNot();
            }labOrt = labOrt / harfHesap.getLabList().size();
        }
        if(harfHesap.getProjeList() != null   && harfHesap.getProjeList().size() != 0){
            for(Proje proje : harfHesap.getProjeList()){
                projeOrt += proje.getProjeNot();
            }projeOrt = projeOrt / harfHesap.getProjeList().size();
        }


        double ort = (harfHesap.getVizeNot() * (harfHesap.getVizeYuzde() / 100.0)) +
                (harfHesap.getFinalNot() * (harfHesap.getFinalYuzde() / 100.0)) +
                (quizOrt * (harfHesap.getQuizYuzde() / 100.0)) +
                (odevOrt * (harfHesap.getOdevYuzde() / 100.0)) +
                (projeOrt * (harfHesap.getProjeYuzde() / 100.0)) +
                (labOrt * (harfHesap.getLabYuzde() / 100.0));




        double sinifOrtalama = harfHesap.getSinifOrt();

        if (Objects.equals(harfHesap.getNotSis(), "Katalog")) {
            harfNotu = katalogSistemiHarfNotuBelirle(ort, harfHesap);
        } else if (Objects.equals(harfHesap.getNotSis(), "Çan")) {
            harfNotu = canSistemiHarfNotuBelirle(ort, harfHesap.getSinifOrt(), harfHesap);
        }
        System.out.println("Harf Notu  = " +harfNotu);
        //harfHesap.setTarih(LocalDate.now());
        HarfHesap yeni = new HarfHesap(harfHesap.getHesapID(),harfHesap.getDersAd(), LocalDate.now(), ort, harfHesap.getVizeYuzde(), harfHesap.getVizeNot(), harfHesap.getFinalYuzde(),harfHesap.getFinalNot(), harfHesap.getNotSis(), harfHesap.getHarfSIS(), harfHesap.getSinifOrt(), harfHesap.getOdevSy(), harfHesap.getOdevYuzde(), harfHesap.getQuizSy(), harfHesap.getQuizYuzde(), harfHesap.getLabSy(), harfHesap.getLabYuzde(), harfHesap.getProjeSy(), harfHesap.getProjeYuzde(), harfNotu );
        return harfHesapRepository.save(yeni);

    }
    public void sil(Long id){
        harfHesapRepository.deleteById(id);
    }
    private String katalogSistemiHarfNotuBelirle(double puan, HarfHesaplayici harfHesap) {
        if ("ilkinci".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (puan >= 90)
                return "AA";
            else if (puan >= 85 && puan <= 89)
                return "BA";
            else if (puan >= 80 && puan <= 84)
                return "BB";
            else if (puan >= 70 && puan <= 79)
                return "CB";
            else if (puan >= 60 && puan <= 69)
                return "CC";
            else if (puan >= 50 && puan <= 59)
                return "DC";
            else if (puan >= 45 && puan <= 49)
                return "DD";
            else
                return "FD";
        } else if ("ikinci".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (puan >= 84)
                return "AA";
            else if (puan >= 77 && puan <= 83)
                return "AB";
            else if (puan >= 71 && puan <= 76)
                return "BA";
            else if (puan >= 66 && puan <= 70)
                return "BB";
            else if (puan >= 61 && puan <= 65)
                return "BC";
            else if (puan >= 56 && puan <= 60)
                return "CB";
            else if (puan >= 50 && puan <= 55)
                return "CC";
            else if (puan >= 46 && puan <= 49)
                return "CD";
            else if (puan >= 40 && puan <= 45)
                return "DC";
            else if (puan >= 33 && puan <= 39)
                return "DD";
            else
                return "FF";
        } else if ("ucuncu".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (puan >= 95)
                return "A";
            else if (puan >= 90 && puan <= 94)
                return "A-";
            else if (puan >= 85 && puan <= 89)
                return "B+";
            else if (puan >= 80 && puan <= 84)
                return "B";
            else if (puan >= 75 && puan <= 79)
                return "B-";
            else if (puan >= 70 && puan <= 74)
                return "C+";
            else if (puan >= 65 && puan <= 69)
                return "C";
            else if (puan >= 60 && puan <= 64)
                return "C-";
            else if (puan >= 55 && puan <= 59)
                return "D+";
            else if (puan >= 50 && puan <= 54)
                return "D";
            else
                return "F";
        }
        return "Geçersiz";
    }

    private String canSistemiHarfNotuBelirle(double puan, double sinifOrtalama, HarfHesaplayici harfHesap) {
        double fark = puan - sinifOrtalama;


        if ("ilkinci".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (fark >= 30)
                return "AA";
            else if (fark >= 25 && fark <= 29)
                return "BA";
            else if (fark >= 20 && fark <= 24)
                return "BB";
            else if (fark >= 10 && fark <= 19)
                return "CB";
            else if (fark >= 0 && fark <= 9)
                return "CC";
            else if (fark >= -10 && puan <= -1)
                return "DC";
            else if (fark >= -15 && puan <= -11)
                return "DD";
            else
                return "FF";
        } else if ("ikinci".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (fark >= 34)
                return "AA";
            else if (fark >= 27 && fark <= 33)
                return "AB";
            else if (fark >= 21 && fark <= 26)
                return "BA";
            else if (fark >= 16 && fark <= 20)
                return "BB";
            else if (fark >= 11 && fark <= 15)
                return "BC";
            else if (fark >= 6 && fark <= 10)
                return "CB";
            else if (fark >= 0 && fark <= 5)
                return "CC";
            else if (fark >= -4 && fark <= -1)
                return "CD";
            else if (fark >= -10 && fark <= -5)
                return "DC";
            else if (fark >= -17 && fark <= -11)
                return "DD";
            else
                return "FF";

        } else if ("ucuncu".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (fark >= 30)
                return "A";
            else if (fark >= 25 && fark <= 29)
                return "A-";
            else if (fark >= 20 && fark <= 84)
                return "B+";
            else if (fark >= 15 && fark <= 21)
                return "B";
            else if (fark >= 10 && fark <= 14)
                return "B-";
            else if (fark >= 5 && fark <= 9)
                return "C+";
            else if (fark >= 0 && fark <= 4)
                return "C";
            else if (fark >= -5 && fark <= -1)
                return "C-";
            else if (fark >= -10 && fark <= -6)
                return "D+";
            else if (fark >= -15 && fark <= -11)
                return "D";
            else
                return "F";
        }
        return "Geçersiz";
    }

    public List<HarfHesap> getTumHarfHesapları() {
        return harfHesapRepository.findAll();
    }

    public Optional<HarfHesap> getHarfHesapById(Long id) {
        return harfHesapRepository.findById(id);
    }
}
