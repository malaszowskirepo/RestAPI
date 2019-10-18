package com.malaszowski.czytelnia.dto;

import com.malaszowski.czytelnia.entity.Ksiazka;

import java.util.List;

public class CzytelniaDTO {
    private int czytelniaId;
    private String nazwa;
    private String miasto;
    private List<KsiazkaDTO> ksiazki;

    public int getCzytelniaId() {
        return czytelniaId;
    }

    public void setCzytelniaId(int czytelniaId) {
        this.czytelniaId = czytelniaId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public List<KsiazkaDTO> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<KsiazkaDTO> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public String toString() {
        return "CzytelniaDTO{" +
                "czytelniaId=" + czytelniaId +
                ", nazwa='" + nazwa + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ksiazki=" + ksiazki +
                '}';
    }
}
