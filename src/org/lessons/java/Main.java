package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Titolo dell'evento: ");
        String titolo = scan.nextLine();

        System.out.println("Data dell'evento: (YYYY-MM-DD");
        LocalDate data = LocalDate.parse(scan.nextLine());

        System.out.println("Numero dei posti totali: ");
        int postiTotali = scan.nextInt();

        Evento evento = new Evento(titolo, data, postiTotali);

        System.out.println("Vuoi effettuare una prenotazione? y/n");
        scan.nextLine();
        String risposta = scan.nextLine();

        while (risposta.equals("y")) {
            try {
                System.out.println("Quanti posti vuoi prenotare? ");
                int postiPrenotati = scan.nextInt();
                evento.prenota(postiPrenotati);
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
            System.out.println("Vuoi effettuare un altra prenotazione? y/n");
            scan.nextLine();
            risposta = scan.nextLine();
        }

        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        System.out.println("Vuoi disdire delle prenotazioni? y/n");
        String disdire = scan.nextLine();

        while (disdire.equals("y")) {
            try {
                System.out.println("Quanti posti vuoi disdire? ");
                int numeroDisdette = scan.nextInt();
                evento.disdici(numeroDisdette);
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
            System.out.println("Vuoi disdire altre prenotazioni? y/n");
            scan.nextLine();
            disdire = scan.nextLine();
        }

        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        scan.close();
    }
}
