package model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;


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
        this.status = status;    }
}
