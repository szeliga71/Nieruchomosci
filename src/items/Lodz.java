package items;

public class Lodz extends Pojazd implements Ruch {

    public Lodz(String nazwa, double szerokosc, double dlugosc, double wysokosc, RodzajPaliwa paliwo, Naped naped) {
        super(nazwa, szerokosc, dlugosc, wysokosc, paliwo, naped);
    }

    @Override
    public String toString() {
        return "Lodz  " + nazwa;
    }
}
