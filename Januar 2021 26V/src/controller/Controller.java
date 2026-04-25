package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Fag opretFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.gemFag(fag);
        return fag;
    }

    public static Lektion opretLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        Lektion lektion = new Lektion(dato, startTid, lokale);
        fag.addLektion(lektion);
        return lektion;
    }

    public static Deltagelse opretDeltagelse(Lektion lektion, Studerende studerende) {
        Deltagelse deltagelse = lektion.opretDeltagelse(studerende);
        // linjen herover linker Deltagelse --- Lektion begge veje og Deltagelse --- Studerende begge veje
        return deltagelse;
    }

    public static Studerende opretStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.gemStuderende(studerende);
        return studerende;
    }

    //-----------------------------------------------------

    // brugt i GUI
    public static ArrayList<Fag> getAlleFag() {
        // TODO
        return null;
    }

    // brugt i gui
    public static void opdaterDeltagelse(Deltagelse deltagelse, boolean registreret, DeltagerStatus deltagerStatus) {
        // TODO
    }
}