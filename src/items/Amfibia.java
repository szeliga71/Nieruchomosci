package items;

public class Amfibia extends Pojazd implements Ruch {


    String model;


    public Amfibia(String nazwa, double szerokosc, double dlugosc, double wysokosc,
                   String model, RodzajPaliwa paliwo, Naped naped) {
        super(nazwa, szerokosc, dlugosc, wysokosc, paliwo, naped);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Amfibia " + model + " " + nazwa;
    }
}

