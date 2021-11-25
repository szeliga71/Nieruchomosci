package osiedle;

import Exceptions.TooManyThingsException;
import items.Items;
import users.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Garaz extends Osiedle implements Comparable<Garaz> {

    private final int id;
    private final int nrGarazu;
    private final int metraz;
    private final int wysokosc;
    private final int objetosc;
    private LocalDate dataWynajecia;
    private LocalDate dataZakonczenia;
    private int idNajemcy;
    private final List<Items> items;


    public Garaz(String nazwa, String adres, int nrGarazu, int metraz, int wysokosc, LocalDate dataWynajecia,
                 LocalDate dataZakonczenia, int idNajemcy) {
        super(nazwa, adres);
        this.id = hashCode();
        this.nrGarazu = nrGarazu;
        this.metraz = metraz;
        this.wysokosc = wysokosc;
        this.objetosc = metraz * wysokosc;
        this.dataWynajecia = dataWynajecia;
        this.dataZakonczenia = dataZakonczenia;
        this.items = new ArrayList<>();
        this.idNajemcy = idNajemcy;
    }


    public int getNrGarazu() {
        return nrGarazu;
    }

    public int getObjetosc() {
        return objetosc;
    }

    public LocalDate getDataWynajecia() {
        return dataWynajecia;
    }

    public void setDataWynajecia(LocalDate dataWynajecia) {
        this.dataWynajecia = dataWynajecia;
    }

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public int getIdNajemcy() {
        return idNajemcy;
    }

    public void setIdNajemcy(int idNajemcy) {
        this.idNajemcy = idNajemcy;
    }

    public List<Items> getItems() {
        return items;
    }

    public int getMetraz() {
        return metraz;
    }

    public int getId() {
        return id;
    }

    public void ustawDaty(LocalDate currentDate) {
        setDataWynajecia(currentDate);
        setDataZakonczenia(currentDate.plusDays(30));
    }

    public void ustawDatyNull() {
        setDataWynajecia(null);
        setDataZakonczenia(null);
    }

    public void ustawNajemce(int idNajemcy) {
        setIdNajemcy(idNajemcy);
    }

    public void usunIdNajemcy() {
        setIdNajemcy(0);
    }


    public double sumaWielkosciPrzedmiotow(Garaz garaz) {

        double ileWGarazu = 0.0;
        for (Items g : garaz.getItems()) {
            ileWGarazu = ileWGarazu + g.rozmiar();
        }
        return ileWGarazu;


    }

    public void wlozDoGarazu(Garaz garaz, Items item, Person person) throws TooManyThingsException {
        if (item.rozmiar() + garaz.sumaWielkosciPrzedmiotow(garaz) >= garaz.getObjetosc()) {
            System.out.println(" TooManyThingsException ");
            throw new TooManyThingsException();
        } else {
            garaz.getItems().add(item);
            person.getItems().remove(item);
        }
    }


    public int compareTo(Garaz o) {
        if (this.getMetraz() == o.getMetraz()) {
            if (this.sumaWielkosciPrzedmiotow(this) > o.sumaWielkosciPrzedmiotow(o)) return 1;
            if (this.sumaWielkosciPrzedmiotow(this) < o.sumaWielkosciPrzedmiotow(o)) return -1;
            else return 0;

        } else {

            if (this.getMetraz() > o.getMetraz()) return -1;
            if (this.getMetraz() < o.getMetraz()) return 1;
            else return 0;
        }
    }

    @Override
    public String toString() {
        return "Garaz " +
                "nr " + nrGarazu +
                ", metraz " + metraz +
                ", dataWynajecia " + dataWynajecia +
                ", dataZakonczenia " + dataZakonczenia;
    }
}
