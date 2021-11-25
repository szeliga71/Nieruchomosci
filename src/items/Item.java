package items;

public class Item extends Items {

    public Item(String nazwa, double szerokosc, double dlugosc, double wysokosc) {
        super(nazwa, szerokosc, dlugosc, wysokosc);
    }

    @Override
    public String toString() {
        return "Przedmiot " + nazwa;

    }
}


