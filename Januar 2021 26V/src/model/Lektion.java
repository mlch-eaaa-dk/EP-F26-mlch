package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    // TODO

    //-----------------------------------------------------

    // brugt i gui
    @Override
    public String toString() {
        return dato + " " + startTid + " " + lokale;
    }
}

