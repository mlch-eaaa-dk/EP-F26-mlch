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

    public Deltagelse opretDeltagelse(Studerende studerende) {
        Deltagelse deltagelse = new Deltagelse(this, studerende);
        // linjen herover linker Deltagelse --> Lektion og Deltagelse --- Studerende begge veje
        deltagelser.add(deltagelse); // linker Lektion --> Deltagelse
        return deltagelse;
    }

    // ingen addDeltagelse() i komposition

    // removeDeltagelse() ikke nødvendig

    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelser.remove(deltagelse);
        // linket Deltagelse --> Lektion nedlægges ikke, da deltagelsen
        // skal slettes fra applikationen, hvis deltagelsen removes fra lektionen
    }

    //-----------------------------------------------------

    // brugt i gui
    @Override
    public String toString() {
        return dato + " " + startTid + " " + lokale;
    }
}

