package org.lessons.java;

import java.time.LocalDate;

public class Evento {
    //ATTRIBUTI
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    //COSTRUTTORI
    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException {
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero dei posti totali deve essere positivo!");
        }

        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere precedente alla data odierna");
        }

        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }
    //GETTER E SETTER
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate nuovaData) throws IllegalArgumentException {
        if (nuovaData.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere passata");
        }
        this.data = nuovaData;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //METODI
    public void prenota(int numeroPosti) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now()) || numeroPosti <= 0) {
            throw new IllegalArgumentException("Non si può prenotare");
        }
        int postiDisponibili = postiTotali - postiPrenotati;
        if (numeroPosti > postiDisponibili) {
            throw new IllegalArgumentException("Posti esauriti");
        }
        postiPrenotati+= numeroPosti;
    }

    public void disdici(int numeroPosti) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now()) || numeroPosti <= 0) {
            throw new IllegalArgumentException("Non puoi effettuare la disdetta");
        }
        if (postiPrenotati == 0) {
            throw new IllegalArgumentException("Non ci sono prenotazioni da cancellare");
        }
        if (numeroPosti > postiPrenotati) {
            throw new IllegalArgumentException("Il numero dei posti da cancellare è > al numero delle prenotazioni");
        }
        postiPrenotati -= numeroPosti;
    }

    @Override
    public String toString() {
        return data.toString() + " - " + titolo;
    }
}
