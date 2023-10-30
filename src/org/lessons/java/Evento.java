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
}
