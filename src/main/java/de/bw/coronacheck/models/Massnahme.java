package de.bw.coronacheck.models;

public class Massnahme {
    private String beschreibung;

    public Massnahme(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }
}
