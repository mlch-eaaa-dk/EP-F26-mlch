package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String navn;
    private String klasse;

    // TODO

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
