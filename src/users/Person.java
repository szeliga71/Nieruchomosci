package users;


import items.Items;
import servis.File;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {


    private final int id = hashCode();
    private final String imie;
    private final String nazwisko;
    private final String PESEL;
    private final String urodzony;
    private final String adres;

    private final List<File> fileList;
    private final Set<Items> items;


    public Person(String imie, String nazwisko, String PESEL, String urodzony, String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.urodzony = urodzony;
        this.adres = adres;
        this.fileList = new ArrayList<>();
        this.items = new HashSet<>();

    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }


    public List<File> getFileList() {
        return fileList;
    }

    public Set<Items> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " "+ PESEL+" "+"data urodzenia " + urodzony + " "+"adres "  + adres;


    }

}
