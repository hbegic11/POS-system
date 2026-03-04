package com.example;

public class StavkaRacuna {
    private String naziv;
    private double cijena;

    public StavkaRacuna(String naziv, double cijena) {
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }
}
