package com.malaszowski.czytelnia.entity;

import javax.persistence.*;

@Entity
@Table(name = "KSIAZKI")
public class Ksiazka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ksiazkaId;

    private String tytul;
    private int rokWydania;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "czytelnikId")
    private Czytelnik czytelnik;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "czytelniaId")
    private Czytelnia czytelnia;

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

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }

    public Czytelnia getCzytelnia() {
        return czytelnia;
    }

    public void setCzytelnia(Czytelnia czytelnia) {
        this.czytelnia = czytelnia;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "ksiazkaId=" + ksiazkaId +
                ", tytul='" + tytul + '\'' +
                ", rokWydania=" + rokWydania +
                ", czytelnik=" + czytelnik +
                ", czytelnia=" + czytelnia +
                '}';
    }
}
