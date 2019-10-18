package com.malaszowski.czytelnia.dto;

import com.malaszowski.czytelnia.entity.Czytelnia;
import com.malaszowski.czytelnia.entity.Czytelnik;

public class KsiazkaDTO {
    private int ksiazkaId;
    private String tytul;
    private int rokWydania;
    //private CzytelnikDTO czytelnik;
    //private CzytelniaDTO czytelnia;

    public int getKsiazkaId() {
        return ksiazkaId;
    }

    public void setKsiazkaId(int ksiazkaId) {
        this.ksiazkaId = ksiazkaId;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

//    public CzytelnikDTO getCzytelnik() {
//        return czytelnik;
//    }
//
//    public void setCzytelnik(CzytelnikDTO czytelnik) {
//        this.czytelnik = czytelnik;
//    }
//
//    public CzytelniaDTO getCzytelnia() {
//        return czytelnia;
//    }
//
//    public void setCzytelnia(CzytelniaDTO czytelnia) {
//        this.czytelnia = czytelnia;
//    }

}
