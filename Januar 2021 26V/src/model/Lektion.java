package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    // link Lektion --> 0..* >Deltagelse
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public String getLokale() {
        return lokale;
    }

    //-----------------------------------------------------

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public Deltagelse opretDeltagelse(Studerende studerende, Lektion lektion) {
        Deltagelse deltagelse = new Deltagelse(studerende, this); // linker Deltagelse --> Lektion
        deltagelser.add(deltagelse); // linker Lektion --> Deltagelse
        return deltagelse;
    }

    // ingen addDeltagelse() i komposition

    // removeDeltagelse() ikke nødvendig

    //-----------------------------------------------------

    // brugt i gui
    @Override
    public String toString() {
        return dato + " " + startTid + " " + lokale;
    }
}

