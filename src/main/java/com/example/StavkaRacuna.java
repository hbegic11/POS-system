package com.example;

public class StavkaRacuna {
    private String naziv;
    private double cijena; // cijena sa PDV-om

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
