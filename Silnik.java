package sda.java9.cons.cars;

public class Silnik extends Czesc {
    public Silnik() {
        super("Silnik");
        super.setKoszt(2000.00);
    }

    @Override
    public String toString() {
        return "{ " + getNazwa() + " koszt: " + getKoszt() + " zł" + " }";
    }
}
