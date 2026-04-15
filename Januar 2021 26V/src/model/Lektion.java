package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    // link Lektion --> 0..* Deltagelse
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

    public Deltagelse createDeltagelse(Lektion lektion, Studerende studerende) {
        Deltagelse deltagelse = new Deltagelse(this, studerende);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    // removeDeltagelse() er ikke et krav

    //-----------------------------------------------------

    // brugt i gui
    @Override
    public String toString() {
        return dato + " " + startTid + " " + lokale;
    }
}

