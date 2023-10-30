package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Titolo dell'evento: ");
        String titolo = scan.nextLine();

        System.out.println("Data dell'evento: (YYYY-MM-DD)");
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
        System.out.println("*************************");

        scan.close();

        Concerto concerto1 = new Concerto("Concerto Rock", LocalDate.of(2024,10, 11), 200, LocalTime.of(20, 45), new BigDecimal("25.00"));
        Concerto concerto2 = new Concerto("Concerto Jazz", LocalDate.of(2024,11, 16), 250, LocalTime.of(18, 30), new BigDecimal("35.00"));
        Concerto concerto3 = new Concerto("Concerto Pop", LocalDate.of(2024,10, 25), 300, LocalTime.of(21, 20), new BigDecimal("50.00"));

        ProgrammEventi programma = new ProgrammEventi("Programma Eventi");

        programma.aggiungiEvento(concerto1);
        programma.aggiungiEvento(concerto2);
        programma.aggiungiEvento(concerto3);

        System.out.println("Elenco eventi ordinati per data:");
        System.out.println(programma.eventiOrdinatiData());

        LocalDate dataDaCercare = LocalDate.of(2023, 10, 30);
        System.out.println("Eventi dopo la data " + dataDaCercare + ":");
        for (Evento eventi : programma.eventiData(dataDaCercare)) {
            System.out.println(eventi);
        }

        System.out.println("Numero totale di eventi nel programma: " + programma.numeroEventi());

    }
}
