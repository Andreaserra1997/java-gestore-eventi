package org.lessons.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammEventi {
    //ATTRIBUTI
    private String titolo;
    private List<Evento> eventi;

    //COSTRUTTORI
    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    //METODI
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> eventiData(LocalDate data) {
        List<Evento> eventiData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().isEqual(data)) {
                eventiData.add(evento);
            }
        }
        return eventiData;
    }
    public int numeroEventi() {
        return eventi.size();
    }

    public void svuotaEventi() {
        eventi.clear();
    }

    public String eventiOrdinatiData() {
        List<Evento> eventiOrdinati = new ArrayList<>(eventi);
        eventiOrdinati.sort((evento1, evento2) -> evento1.getData().compareTo(evento2.getData()));

        StringBuilder risultato = new StringBuilder();
        for (Evento evento : eventiOrdinati) {
            risultato.append(evento.getData().toString()).append(" - ").append(evento.getTitolo()).append("\n");
        }
        return risultato.toString();
    }
}
