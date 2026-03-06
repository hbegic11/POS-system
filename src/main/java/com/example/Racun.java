package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Racun {

    private ArrayList<StavkaRacuna> stavke = new ArrayList<>();

    public void dodajStavku(StavkaRacuna s) {
        stavke.add(s);
    }

    public double ukupno() {
        double suma = 0;
        for (StavkaRacuna s : stavke) suma += s.getCijena();
        return suma;
    }

    public double osnovica() {
        return ukupno() / 1.17;
    }

    public double pdv() {
        return ukupno() - osnovica();
    }

    public ArrayList<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void ispisiRacun(String konobar, int brojTransakcije) {
        System.out.println("\nApeiron");
        System.out.println("Pere Krece 13");
        System.out.println("Banja Luka 78000");
        System.out.println("=============================================");
        System.out.println("Datum: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Vrijeme: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("=============================================");
        System.out.println("              FISKALNI RAČUN                 ");
        System.out.println("=============================================");

        for (StavkaRacuna s : stavke) {
            System.out.printf("%-30s %8.2f KM%n", s.getNaziv(), s.getCijena());
        }

        System.out.println("=============================================");
        System.out.printf("%-30s %8.2f KM%n", "Osnovica:", osnovica());
        System.out.printf("%-30s %8.2f KM%n", "PDV (17%):", pdv());
        System.out.printf("%-30s %8.2f KM%n", "Ukupno:", ukupno());
        System.out.println("=============================================");
        System.out.println("Konobar: " + konobar);
        System.out.println("Broj transakcije: " + brojTransakcije);
    }

    public void sacuvajUTXT(String konobar, int brojTransakcije, String imeFajla) {
        try (FileWriter fw = new FileWriter(imeFajla)) {

            fw.write("Radnja One\n");
            fw.write("Nepoznata 33\n");
            fw.write("Banja Luka 78000\n");
            fw.write("=============================================\n");
            fw.write("Datum: " + java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n");
            fw.write("Vrijeme: " + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")) + "\n");
            fw.write("=============================================\n");
            fw.write("                FISKALNI RAČUN               \n");
            fw.write("=============================================\n");

            for (StavkaRacuna s : stavke) {
                fw.write(String.format("%-30s %8.2f KM%n", s.getNaziv(), s.getCijena()));
            }

            fw.write("=============================================\n");
            fw.write(String.format("%-30s %8.2f KM%n", "Osnovica:", osnovica()));
            fw.write(String.format("%-30s %8.2f KM%n", "PDV (17%):", pdv()));
            fw.write(String.format("%-30s %8.2f KM%n", "Ukupno za uplatu:", ukupno()));
            fw.write("=============================================\n");
            fw.write("Konobar: " + konobar + "\n");
            fw.write("Broj transakcije: " + brojTransakcije + "\n");

            System.out.println("Račun spremljen u fajl: " + imeFajla);

        } catch (IOException e) {
            System.out.println("Greška prilikom spremanja računa: " + e.getMessage());
        }
    }
}
