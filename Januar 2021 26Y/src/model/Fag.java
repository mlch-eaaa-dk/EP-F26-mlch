package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String navn;
    private String klasse;

    // link Fag --> 0..* Lektion
    private final ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
    }

    public String getNavn() {
        return navn;
    }

    public String getKlasse() {
        return klasse;
    }

    //-----------------------------------------------------

    public ArrayList<Lektion> getLektioner() {
        return lektioner;
    }

    public void addLektion(Lektion lektion) {
        lektioner.add(lektion); // linker Fag --> Lektion
    }

    // removeLektion() ikke nødvendig

    //-----------------------------------------------------

    // S4
    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
        // TODO
        return null;
    }

    //-----------------------------------------------------

    // brugt i gui
    @Override
    public String toString() {
        return navn + " " + klasse;
    }
}
