package com.example;

import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int brojTransakcije = 1000 + random.nextInt(9000); // generiraj JEDAN broj


        System.out.print("Unesite ime ili broj kasira: ");
        String kasir = sc.nextLine();

        Racun racun = new Racun();

        // Kategorije i podmeniji
        Meni topli = new Meni("Topli napitci");
        topli.dodajStavkuUMenu(new StavkaRacuna("Kafa", 2.00));
        topli.dodajStavkuUMenu(new StavkaRacuna("Nescafe", 2.50));
        topli.dodajStavkuUMenu(new StavkaRacuna("Topla čokolada", 2.50));
        topli.dodajStavkuUMenu(new StavkaRacuna("Čaj", 2.00));

        Meni gazirana = new Meni("Gazirana pića");
        gazirana.dodajStavkuUMenu(new StavkaRacuna("Coca Cola", 3.00));
        gazirana.dodajStavkuUMenu(new StavkaRacuna("Fanta", 3.00));
        gazirana.dodajStavkuUMenu(new StavkaRacuna("Sprite", 3.00));
        gazirana.dodajStavkuUMenu(new StavkaRacuna("Red Bull", 5.00));

        Meni sokovi = new Meni("Sokovi");
        sokovi.dodajStavkuUMenu(new StavkaRacuna("Ledeni čaj", 3.00));
        sokovi.dodajStavkuUMenu(new StavkaRacuna("Sok jabuka", 3.00));
        sokovi.dodajStavkuUMenu(new StavkaRacuna("Sok jagoda", 3.00));
        sokovi.dodajStavkuUMenu(new StavkaRacuna("Cedevita", 2.50));

        Meni cjedjeni = new Meni("Cijeđeni sokovi");
        cjedjeni.dodajStavkuUMenu(new StavkaRacuna("Cijeđena narandža", 5.00));
        cjedjeni.dodajStavkuUMenu(new StavkaRacuna("Limunada", 4.00));

        int izbor;
        do {
            System.out.println("\n=============================================");
            System.out.println(" ODABERITE PIĆE ");
            System.out.println("=============================================");
            System.out.println("1. Topli napitci");
            System.out.println("2. Gazirana pića");
            System.out.println("3. Sokovi");
            System.out.println("4. Cijeđeni sokovi");
            System.out.println("0. Izlaz i račun");
            System.out.print("Unesite izbor (0-4): ");

            izbor = unosOpcije(sc, 0, 4);

            switch (izbor) {
                case 1 -> topli.prikaziMeni(racun, sc);
                case 2 -> gazirana.prikaziMeni(racun, sc);
                case 3 -> sokovi.prikaziMeni(racun, sc);
                case 4 -> cjedjeni.prikaziMeni(racun, sc);
                case 0 -> {
                    racun.ispisiRacun(kasir, brojTransakcije);


                    String imeFajla = "Racun_" + brojTransakcije + ".txt";

                    // spremanje u TXT
                    racun.sacuvajUTXT(kasir, brojTransakcije, imeFajla);
                }

            }

        } while (izbor != 0);

        sc.close();
    }

    // Validacija unosa
    public static int unosOpcije(Scanner sc, int min, int max) {
        int izbor;
        while (true) {
            try {
                String linija = sc.nextLine();
                izbor = Integer.parseInt(linija);
                if (izbor >= min && izbor <= max) return izbor;
                else System.out.print("Pogrešan unos! Unesite broj od " + min + " do " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Pogrešan unos! Unesite broj od " + min + " do " + max + ": ");
            }
        }
    }

}
