package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataOraFormattata() {
        return getData().toString() + " " + ora.toString();
    }

    public String getPrezzoFormattato() {
        DecimalFormat df = new DecimalFormat("##,##€");
        return df.format(prezzo);
    }

    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}
