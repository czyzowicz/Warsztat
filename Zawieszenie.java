package sda.java9.cons.cars;

public class Zawieszenie extends Czesc {
    public Zawieszenie() {
        super("Zawieszenie");
        super.setKoszt(1500.00);
    }

    @Override
    public String toString() {
        return "{ " + getNazwa() + " koszt: " + getKoszt() + " zł" + " }";
    }
}
