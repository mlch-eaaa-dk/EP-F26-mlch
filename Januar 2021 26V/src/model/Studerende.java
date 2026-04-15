package model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;

    // associering Studerende --> 0..* Deltagelse
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    //-----------------------------------------------------

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse); // linker Studerende --> Deltagelse
            deltagelse.setStuderende(this); // linker Deltagelse --> Studerende
        }
    }

    // removeDeltagelse() er ikke et krav

    //-----------------------------------------------------

    // S3
    public int antalFraværsLektioner() {
        // TODO
        return 0;
    }
}
