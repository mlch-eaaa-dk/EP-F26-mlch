package model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;

    // link Deltagelse --> 1 Lektion
    private final Lektion lektion;

    // link Deltagelse --> 1 Studerende
    private Studerende studerende;

    Deltagelse(Lektion lektion, Studerende studerende) { // OBS: package visible
        this.registreret = false;
        this.status = DeltagerStatus.TILSTEDE;

        this.lektion = lektion; // linker Deltagelse --> Lektion
        this.setStuderende(studerende); // linker Deltagelse --- Studerende begge veje
        // Alternativ til linjen herover:
        // studerende.addDeltagelse(this); // linker Studerende --- Deltagelse begge veje

        // Bemærk: Lektion.createDeltagelse() er eneste metode, der bruger denne konstruktor.
        // Bemærk: Lektion.createDeltagelse() linker Lektion --> Deltagelse
    }

    public boolean isRegistreret() {
        return registreret;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    //-----------------------------------------------------

    public Lektion getLektion() {
        return lektion;
    }

    // ingen setLektion() i komposition

    public Studerende getStuderende() {
        return studerende;
    }

    public void setStuderende(Studerende studerende) {
        if (this.studerende != studerende) {
            Studerende oldStuderende = this.studerende;
            if (oldStuderende != null) {
                oldStuderende.removeDeltagelse(this); // af-linker Studerende --- Deltagelse begge veje
            }
            this.studerende = studerende; // linker Deltagelse --> Studerende
            if (studerende != null) {
                studerende.addDeltagelse(this); // linker Studerende --> Deltagelse
            }
        }
    }
    // Bemærk: setStuderende(null) nedlægges forbindelsen mellem Deltagelse og Studerende

    //-----------------------------------------------------

    // S2
    public boolean erRegistreretFraværende() {
         return registreret  && status != DeltagerStatus.TILSTEDE;
    }

    //-----------------------------------------------------

    // brugt i gui
    @Override
    public String toString() {
        return registreret + " " + status;
    }

    // brugt i controller
    public void setRegistreret(boolean registreret) {
        this.registreret = registreret;
    }

    // brugt i controller
    public void setStatus(DeltagerStatus status) {
        this.status = status;
    }
}
