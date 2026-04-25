package model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;

    // link Studerende --> 0..* Deltagelse
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return this.navn;
    }

    public String getEmail() {
        return email;
    }

    //-----------------------------------------------------

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse); // linker Studerende --> deltagelse
            deltagelse.setStuderende(this); // linker Deltagelse --> Studerende
        }
    }

    // removeDeltagelse() ikke nødvendig

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse); // af-linker Studerende --> Deltagelse
            deltagelse.setStuderende(null); // af-linker Deltagelse --> Studerende
        }
    }

    //-----------------------------------------------------

    // S3
    public int antalFraværsLektioner() {
        int antal = 0;
        for (Deltagelse deltagelse : deltagelser) {
            if (deltagelse.erRegistreretFraværende()) {
                antal++;
            }
        }
        return antal;
    }

}
