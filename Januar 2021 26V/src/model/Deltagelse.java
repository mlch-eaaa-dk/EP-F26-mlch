package model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;

    // link Deltagelse --> 1 Lektion
    private final Lektion lektion;

    // link Deltagelse --> 1 Studerende
    private Studerende studerende;

    public Deltagelse(Lektion lektion, Studerende studerende) {
        registreret = false;
        status = DeltagerStatus.TILSTEDE;
        this.lektion = lektion; // linker Deltagelse --> Lektion
        studerende.addDeltagelse(this); // linker studerende --- Deltagelse begge veje
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

    // setLektion() skal ikke med (pga. komposition)

    public Studerende getStuderende() {
        return studerende;
    }

    public void setStuderende(Studerende studerende) {
        if (this.studerende != studerende) {
            this.studerende = studerende; // linker Deltagelse --> Studerende
            if (studerende != null) {
                studerende.addDeltagelse(this); // linker Studerende --> DEltagelse
            }
        }
    }

    //-----------------------------------------------------

    // S2
    public boolean erRegistreretFraværende() {
        return status != DeltagerStatus.TILSTEDE && registreret;
    }

    // brugt i gui
    @Override
    public String toString() {
        return studerende.getNavn() + " " + registreret + " " + status;
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
