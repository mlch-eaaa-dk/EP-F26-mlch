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
        return new ArrayList<>(lektioner);
    }

    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion); // linker Fag --> Lektion
        }
    }

    // removeLektion() ikke nødvendig

    public void removeLektion(Lektion lektion) {
        if (lektioner.contains(lektion)) {
            lektioner.remove(lektion);
        }
    }

    //-----------------------------------------------------

    // S4
    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
        ArrayList<Studerende> sygePåDato = new ArrayList<>();
        for (Lektion lektion : lektioner) {
            if (lektion.getDato().equals(dato)) {
                for (Deltagelse deltagelse : lektion.getDeltagelser()) {
                    Studerende studerende = deltagelse.getStuderende();
                    if (deltagelse.getStatus() == DeltagerStatus.SYG && !sygePåDato.contains(studerende)) {
                        sygePåDato.add(studerende);
                    }
                }
            }
        }
        return sygePåDato;
    }

    //-----------------------------------------------------

    // brugt i gui
    @Override
    public String toString() {
        return navn + " " + klasse;
    }
}
