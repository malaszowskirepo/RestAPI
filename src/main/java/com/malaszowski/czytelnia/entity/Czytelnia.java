package com.malaszowski.czytelnia.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Czytelnia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int czytelniaId;

    private String nazwa;
    private String miasto;
    @OneToMany(mappedBy = "czytelnia")
    private List<Ksiazka> ksiazki;

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

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public String toString() {
        return "Czytelnia{" +
                "czytelniaId=" + czytelniaId +
                ", nazwa='" + nazwa + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ksiazki=" + ksiazki +
                '}';
    }
}
