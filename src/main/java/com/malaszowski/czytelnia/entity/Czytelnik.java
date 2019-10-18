package com.malaszowski.czytelnia.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CZYTELNICY")
public class Czytelnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int czytelnikId;

    private String imie;
    private String nazwisko;

    @OneToMany(mappedBy = "czytelnik")
    private List<Ksiazka> ksiazki;

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

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public String toString() {
        return "Czytelnik{" +
                "czytelnikId=" + czytelnikId +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", ksiazki=" + ksiazki +
                '}';
    }
}
