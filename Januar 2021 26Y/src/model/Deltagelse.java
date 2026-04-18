package model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;

    // link Deltagelse --> 1 Lektion
    private final Lektion lektion;

    // link Deltagelse --> 1 Studerende
    private Studerende studerende;

    public Deltagelse(Lektion lektion, Studerende studerende) {
        this.registreret = false;
        this.status = DeltagerStatus.TILSTEDE;
        this.lektion = lektion; // linker Deltagelse --> Lektion
        this.studerende = studerende; // linker Deltagelse --> Studerende
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
        this.studerende = studerende; // linker Deltagelse --> Studerende
    }

    //-----------------------------------------------------

    // S2
    public boolean erRegistreretFraværende() {
        // TODO
        return false;
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
