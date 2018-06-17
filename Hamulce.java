package sda.java9.cons.cars;

public class Hamulce extends Czesc {
    public Hamulce() {
        super("Hamulce");
        super.setKoszt(500.00);
    }

    @Override
    public String toString() {
        return "{ " + getNazwa() + " koszt: " + getKoszt() + " zł" + " }";
    }
}
