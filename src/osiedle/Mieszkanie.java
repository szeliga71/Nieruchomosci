package osiedle;


import users.Person;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Mieszkanie extends Osiedle implements Comparable<Mieszkanie> {

    private final int id;
    private int nrBloku;
    private final int nrMieszkania;
    private final int metraz;
    private LocalDate dataWynajecia;
    private LocalDate dataZakonczenia;
    private int idNajemcy;

    private final Set<Person> lokatorzy;


    public Mieszkanie(String nazwa, String adres, int nrMieszkania, int metraz, LocalDate dataWynajecia,
                      LocalDate dataZakonczenia, int idNajemcy) {
        super(nazwa, adres);
        this.id = hashCode();
        this.nrMieszkania = nrMieszkania;
        this.metraz = metraz;
        this.dataWynajecia = dataWynajecia;
        this.dataZakonczenia = dataZakonczenia;
        this.idNajemcy = idNajemcy;
        lokatorzy = new HashSet<>();

    }


    public int getIdNajemcy() {
        return idNajemcy;
    }

    public void setIdNajemcy(int idNajemcy) {
        this.idNajemcy = idNajemcy;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }


    public Set<Person> getLokatorzy() {
        return lokatorzy;
    }


    public int getMetraz() {
        return metraz;
    }

    public LocalDate getDataWynajecia() {
        return dataWynajecia;
    }

    public void setDataWynajecia(LocalDate dataWynajecia) {
        this.dataWynajecia = dataWynajecia;
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

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Mieszkanie o) {

        if (this.getMetraz() > o.getMetraz()) return -1;
        if (this.getMetraz() < o.getMetraz()) return 1;
        return 0;
    }


    @Override
    public String toString() {
        return "Mieszkanie id " +
                id +
                ", nrBloku " + nrBloku +
                ", nrMieszkania " + nrMieszkania +
                ", metraz " + metraz +
                ", dataWynajecia " + dataWynajecia +
                ", dataZakonczenia " + dataZakonczenia + '\n';


    }


}
