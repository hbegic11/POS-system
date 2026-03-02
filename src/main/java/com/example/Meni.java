package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Meni {

    private String naziv;
    private ArrayList<StavkaRacuna> stavkeMeni = new ArrayList<>();

    public Meni(String naziv) {
        this.naziv = naziv;
    }

    public void dodajStavkuUMenu(StavkaRacuna s) {
        stavkeMeni.add(s);
    }

    public void prikaziMeni(Racun racun, Scanner sc) {
        int izbor;
        do {
            System.out.println("\n=============================================");
            System.out.println(" " + naziv.toUpperCase());
            System.out.println("=============================================");
            for (int i = 0; i < stavkeMeni.size(); i++) {
                System.out.printf("%d. %-30s %5.2f KM%n", i + 1, stavkeMeni.get(i).getNaziv(), stavkeMeni.get(i).getCijena());
            }
            System.out.println("0. Nazad");
            System.out.print("Unesite izbor: ");
            izbor = Main.unosOpcije(sc, 0, stavkeMeni.size());

            if (izbor != 0) {
                racun.dodajStavku(stavkeMeni.get(izbor - 1));
            }
        } while (izbor != 0);
    }
}
