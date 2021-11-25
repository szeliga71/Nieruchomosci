package items;

public class AutoMiejskie extends Pojazd {


    String model;

    public AutoMiejskie(String nazwa, double szerokosc, double dlugosc, double wysokosc, String model, RodzajPaliwa paliwo, Naped naped) {
        super(nazwa, szerokosc, dlugosc, wysokosc, paliwo, naped);
        this.model = model;
    }

    @Override
    public String toString() {
        return "AutoMiejskie " + model + " " + nazwa;

    }
}

