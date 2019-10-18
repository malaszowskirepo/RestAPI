package com.malaszowski.czytelnia.dto;

import com.malaszowski.czytelnia.entity.Ksiazka;

import java.util.List;

public class CzytelnikDTO {
    private int czytelnikId;
    private String imie;
    private String nazwisko;
    private List<KsiazkaDTO> ksiazki;

    public int getCzytelnikId() {
        return czytelnikId;
    }

    public void setCzytelnikId(int czytelnikId) {
        this.czytelnikId = czytelnikId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public List<KsiazkaDTO> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<KsiazkaDTO> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public String toString() {
        return "CzytelnikDTO{" +
                "czytelnikId=" + czytelnikId +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", ksiazki=" + ksiazki +
                '}';
    }
}
