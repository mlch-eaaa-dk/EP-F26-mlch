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
        this.studerende = studerende; // inker Deltagelse --> Studerende
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

    // setStuderende() er ikke et krav

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
        // TODO
        return null;
    }

    // brugt i controller
    public void setRegistreret(boolean registreret) {
        // TODO
    }

    // brugt i controller
    public void setStatus(DeltagerStatus status) {
       // TODO
    }
}
