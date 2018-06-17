package sda.java9.cons.cars;

import java.util.ArrayList;
import java.util.List;

public class Warsztat {

    private List<String> obslugiwaneMarki;
    private List<Czesc> czesciNaStanie;
    private double zysk;
    private final static double KOSZT_BEZ_WYMIANY = 50.0;
    private final static double MARZA = 31.0;
    public static int counter = 0;
    public static double dziennyZysk = 0.0;

    public static List<String> losoweMarki() {
        int liczbaLosowychMarek = (int) (1 + Math.random() * 8);
        List<String> losoweMarki = new ArrayList<>(Samochod.WSZYTKIE_MARKI.subList(0, liczbaLosowychMarek));
        return losoweMarki;
    }

    public static List<Czesc> losoweCzesci() {
        int liczbaLosowychCzesci = (int) (10 + Math.random() * 91);
        List<Czesc> losoweCzesci = new ArrayList<>(liczbaLosowychCzesci);
        for (int i = 0; i < liczbaLosowychCzesci; i++) {
            Czesc czesc;
            int losoweCzesciSamochodu = (int) (1 + Math.random() * 5);
            switch (losoweCzesciSamochodu) {
                case 1:
                    czesc = new Silnik();
                    break;
                case 2:
                    czesc = new Zawieszenie();
                    break;
                case 3:
                    czesc = new Hamulce();
                    break;
                case 4:
                    czesc = new Karoseria();
                    break;
                case 5:
                    czesc = new SkrzyniaBiegow();
                    break;
                default:
                    czesc = new Silnik();
            }
            losoweCzesci.add(czesc);
        }
        return losoweCzesci;
    }

    public static void main(String[] args) {
        Warsztat warsztat1 = new Warsztat(losoweMarki(), losoweCzesci());
        System.out.println(warsztat1);
        while (counter < 3) {
            try {
                Thread.sleep((int) (2000 + Math.random() * 3000));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            Samochod losowySamochod = Samochod.stworzLosowySamochod();
            System.out.println("Klient przyjechał do warsztatu z samochodem marki " + losowySamochod.getMarka());
            System.out.println("Czy potrafimy obsłużyć samochód klienta : " + warsztat1.czyMoznaNaprawic(losowySamochod));

            if (warsztat1.czyMoznaNaprawic(losowySamochod)) {
                System.out.println("Koszt naprawy Pana samochodu wynosi " + warsztat1.kosztKlienta(losowySamochod) + " zł.");
                System.out.println(losowySamochod);
                System.out.println("Będzie Pan zadowolony i Pana żona też!");
                System.out.println(rachunek(losowySamochod).toString());
                warsztat1.naprawa(losowySamochod);
                System.out.println(losowySamochod);
                warsztat1.setZysk(warsztat1.kosztNaprawy(losowySamochod) - warsztat1.kosztKlienta(losowySamochod));
                dziennyZysk = warsztat1.getZysk() + dziennyZysk;
            } else {
                System.out.println("Przkyto nam nie możemy naprawić Pana samochodu.\nKoszt diagnostyki wynosi: " + KOSZT_BEZ_WYMIANY + " zł.");
                dziennyZysk = dziennyZysk + KOSZT_BEZ_WYMIANY;
            }
            counter++;
        }
        System.out.println("Dzienny zysk warsztatu wynosi " + dziennyZysk + " zł.");
    }

    public Warsztat(List<String> obslugiwaneMarki, List<Czesc> czesciNaStanie) {
        this.obslugiwaneMarki = obslugiwaneMarki;
        this.czesciNaStanie = czesciNaStanie;
    }

    public boolean czyMoznaNaprawic(Samochod samochod) {
        boolean czyObslugujeMarke = obslugiwaneMarki.contains(samochod.getMarka());
        boolean czyMamyTakieCzesci = czesciNaStanie.containsAll(samochod.getPopsuteCzesci());
        return czyMamyTakieCzesci && czyObslugujeMarke;
    }

    public double kosztKlienta(Samochod samochod) {
        double sum = 0;
        for (Czesc cz : samochod.getPopsuteCzesci()) {
            sum += cz.getKoszt();
        }
        return (sum * (MARZA / 100)) + sum;
    }

    public double kosztNaprawy(Samochod samochod) {
        double sum = 0;
        for (Czesc cz : samochod.getPopsuteCzesci()) {
            sum += cz.getKoszt();
        }
        return sum;
    }

    public void naprawa(Samochod samochod) {
        for (Czesc czesc : samochod.getPopsuteCzesci()) {
            czesciNaStanie.remove(czesc);
        }
        samochod.getPopsuteCzesci().clear();
    }


    public static StringBuilder rachunek(Samochod samochod) {
        double koszt = 0;
        StringBuilder rachunek = new StringBuilder();
        rachunek.append(" ____________________________________\n");
        rachunek.append(String.format("|%-14sRachunek%14s|\n", "", ""));
        rachunek.append(String.format("|%36s|\n", ""));
        for (Czesc czesc : samochod.getPopsuteCzesci()) {
            rachunek.append(String.format("|%-22s%14.2f|\n", czesc.getNazwa(), czesc.getKoszt()));
            koszt = czesc.getKoszt() + koszt;
        }
        rachunek.append(String.format("|%36s|\n", ""));
        rachunek.append(String.format("|%-22s%9.2f|\n", "Koszt naprawy z robocizną: ", (koszt * (MARZA / 100)) + koszt));
        rachunek.append("|____________________________________|\n");
        return rachunek;
    }

    @Override
    public String toString() {
        return "Warsztat{" +
                "obslugiwaneMarki " + obslugiwaneMarki.toString() +
                ", czesciNaStanie " + czesciNaStanie.toString() +
                ", zysk " + zysk + "}";
    }

    public List<String> getObslugiwaneMarki() {
        return obslugiwaneMarki;
    }

    public void setObslugiwaneMarki(List<String> obslugiwaneMarki) {
        this.obslugiwaneMarki = obslugiwaneMarki;
    }

    public List<Czesc> getCzesciNaStanie() {
        return czesciNaStanie;
    }

    public void setCzesciNaStanie(List<Czesc> czesciNaStanie) {
        this.czesciNaStanie = czesciNaStanie;
    }

    public double getZysk() {
        return zysk;
    }

    public void setZysk(double zysk) {
        this.zysk = zysk;
    }
}