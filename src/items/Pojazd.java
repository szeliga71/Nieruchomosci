package items;

public class Pojazd extends Items implements Ruch {

    RodzajPaliwa paliwo;
    Naped naped;


    public Pojazd(String nazwa, double szerokosc, double dlugosc, double wysokosc, RodzajPaliwa paliwo, Naped naped) {
        super(nazwa, szerokosc, dlugosc, wysokosc);
        this.paliwo = paliwo;
        this.naped = naped;

    }

    @Override
    public void ruch() {
        if ((paliwo == RodzajPaliwa.WIATR) || naped == Naped.ZAGIEL) {
            plyn();
        } else if (naped == Naped.KOLASRUBA) {
            jedz();
            plyn();
        } else {
            jedz();
        }
    }
}
