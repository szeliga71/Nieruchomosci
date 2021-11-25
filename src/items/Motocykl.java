package items;

public class Motocykl extends Pojazd {

    private final String model;

    public Motocykl(String nazwa, double szerokosc, double dlugosc,
                    double wysokosc, String model, RodzajPaliwa paliwo, Naped naped) {
        super(nazwa, szerokosc, dlugosc, wysokosc, paliwo, naped);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Motocykl " + model + " " + nazwa;
    }
}