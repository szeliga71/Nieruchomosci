package items;

public class AutoTerenowe extends Pojazd {


    String model;

    public AutoTerenowe(String nazwa, double szerokosc, double dlugosc, double wysokosc, String model, RodzajPaliwa paliwo, Naped naped) {
        super(nazwa, szerokosc, dlugosc, wysokosc, paliwo, naped);
        this.model = model;

    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "AutoTerenowe " + nazwa + " " + model;
    }
}
