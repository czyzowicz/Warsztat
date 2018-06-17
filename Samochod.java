package sda.java9.cons.cars;

import java.util.ArrayList;
import java.util.List;

public class Samochod {

    private String marka;
    private int rok;
    private List<Czesc> popsuteCzesci = new ArrayList<>();

    public final static List<String> WSZYTKIE_MARKI = new ArrayList<>();

    static {
        WSZYTKIE_MARKI.add("BMW");
        WSZYTKIE_MARKI.add("HONDA");
        WSZYTKIE_MARKI.add("TOYOTA");
        WSZYTKIE_MARKI.add("AUDI");
        WSZYTKIE_MARKI.add("OPEL");
        WSZYTKIE_MARKI.add("FORD");
        WSZYTKIE_MARKI.add("FIAT");
        WSZYTKIE_MARKI.add("CITROEN");
    }

    public static Samochod stworzLosowySamochodZPosputymSilnikiem() {
        String losowaMarka = WSZYTKIE_MARKI.get((int) (Math.random() * 8));
        Samochod samochod = new Samochod();
        samochod.setMarka(losowaMarka);
        int rokProdkucji = (int) (1990 + Math.random() * 28);
        samochod.setRok(rokProdkucji);
        Silnik popsutySilnik = new Silnik();
        samochod.getPopsuteCzesci().add(popsutySilnik);
        return samochod;
    }

    public static Samochod stworzLosowySamochod() {
        String losowaMarka = WSZYTKIE_MARKI.get((int) (Math.random() * 8));
        Samochod samochod = new Samochod();
        samochod.setMarka(losowaMarka);
        int rokProdkucji = (int) (1990 + Math.random() * 28);
        samochod.setRok(rokProdkucji);
        int liczbaLosowychCzesci = (int) (1 + Math.random() * 5);
        samochod.popsuteCzesci.add(new Silnik());
        samochod.popsuteCzesci.add(new Hamulce());
        samochod.popsuteCzesci.add(new Karoseria());
        samochod.popsuteCzesci.add(new Zawieszenie());
        samochod.popsuteCzesci.add(new SkrzyniaBiegow());
        int dzialajaceCzesci = 5 - liczbaLosowychCzesci;
        for (int i = 0; i < dzialajaceCzesci; i++) {
            int indeksCzesciDoUsuniecia = (int) (Math.random() * samochod.popsuteCzesci.size());
            samochod.popsuteCzesci.remove(indeksCzesciDoUsuniecia);
        }
        return samochod;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public List<Czesc> getPopsuteCzesci() {
        return popsuteCzesci;
    }

    public void setPopsuteCzesci(List<Czesc> popsuteCzesci) {
        this.popsuteCzesci = popsuteCzesci;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "marka='" + marka + '\'' +
                ", rok=" + rok +
                ", popsuteCzesci=" + popsuteCzesci +
                '}';
    }
}
