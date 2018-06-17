package sda.java9.cons.cars;

public class Karoseria extends Czesc {
    public Karoseria() {
        super("Karoseria");
        super.setKoszt(1000.00);
    }

    @Override
    public String toString() {
        return "{ " + getNazwa() + " koszt: " + getKoszt() + " zł" + " }";
    }
}
