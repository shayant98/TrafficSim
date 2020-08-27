package sr.unasat.trafficsim.entities;

public class Car {
    private int volgNr;
    private String kenteken;
    private boolean prio;
    private String prioType;

    public Car(int volgNr, String kenteken, boolean prio) {
        this.volgNr = volgNr;
        this.kenteken = kenteken;
        this.prio = prio;
    }
    public Car(int volgNr, String kenteken, boolean prio, String prioType) {
        this.volgNr = volgNr;
        this.kenteken = kenteken;
        this.prio = prio;
        this.prioType = prioType;
    }

    public int getVolgNr() {
        return volgNr;
    }

    public void setVolgNr(int volgNr) {
        this.volgNr = volgNr;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public boolean isPrio() {
        return prio;
    }

    public void setPrio(boolean prio) {
        this.prio = prio;
    }

    public String getPrioType() {
        return prioType;
    }

    public void setPrioType(String prioType) {
        this.prioType = prioType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "volgNr=" + volgNr +
                ", kenteken='" + kenteken + '\'' +
                ", prio=" + prio +
                ", prioType='" + prioType + '\'' +
                '}';
    }
}
