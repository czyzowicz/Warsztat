package sda.java9.cons.cars;

import java.util.Objects;

public abstract class Czesc {

    private String nazwa;
    private double koszt;

    public Czesc(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Czesc)) return false;
        Czesc czesc = (Czesc) o;
        return Double.compare(czesc.koszt, koszt) == 0 &&
                Objects.equals(nazwa, czesc.nazwa);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nazwa, koszt);
    }
}
