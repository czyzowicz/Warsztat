package sda.java9.cons.cars;

public class SkrzyniaBiegow extends Czesc {
    public SkrzyniaBiegow() {
        super("Skrzynia Biegów");
        super.setKoszt(800.00);
    }

    @Override
    public String toString() {
        return " { " + getNazwa() + " koszt: " + getKoszt() + " zł" + " }";
    }
}
