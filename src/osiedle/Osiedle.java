package osiedle;


import Exceptions.ProblematicTenantException;
import servis.File;
import servis.Time;
import users.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;

public class Osiedle {

    String nazwa;
    String adres;
    Time t;
    LocalDate startDate;


    private final Map<Osiedle, Integer> wynajem = new HashMap<>();


    public Osiedle(String nazwa, String adres, Time t, LocalDate startDate) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.t = t;
        this.startDate = startDate;

    }

    public Osiedle(String nazwa, String adres) {

    }


    public String getNazwa() {
        return nazwa;
    }

    public Map<Osiedle, Integer> getWynajem() {
        return wynajem;
    }

    @Override
    public String toString() {
        return " Osiedle " + nazwa +
                " adres  " + adres;


    }


// sprawdzenie przy wynajmie czy uzytkownik nie naruszyl warunku 3 File

    public boolean sprawdzFile(Person person) {
        boolean fileOk = false;
        if (person.getFileList().size() >= 3) {
            fileOk = true;
        }
        return fileOk;
    }

    public void najemM(Mieszkanie mieszkanie, Person person) throws ProblematicTenantException {

        if (sprawdzFile(person)) {
            System.out.println("ProblematicTenantException");
            throw new ProblematicTenantException(person, pobierzListeNieruchZFile(person));

        } else {
            mieszkanie.ustawNajemce(person.getId());
            zamelduj(mieszkanie, person);
            mieszkanie.ustawDaty(startDate.plusDays(t.getDay()));
            getWynajem().put(mieszkanie, person.getId());
        }
    }


    public void najemG(Garaz garaz, Person person) throws ProblematicTenantException {
        if (sprawdzFile(person)) {
            System.out.println("ProblematicTenantException");
            throw new ProblematicTenantException(person, pobierzListeNieruchZFile(person));
        } else {
            garaz.ustawNajemce(person.getId());
            garaz.ustawDaty(startDate.plusDays(t.getDay()));
            getWynajem().put(garaz, person.getId());
        }
    }

    public void zamelduj(Mieszkanie m, Person p) {
        m.getLokatorzy().add(p);


    }


    public List<Mieszkanie> pokazMieszkaniaUzytkownika(int idPerson) {
        List<Mieszkanie> m = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Mieszkanie.class) && (entry.getValue() != null) && (entry.getValue().equals(idPerson))) {
                m.add((Mieszkanie) entry.getKey());


            }

        }
        return m;


    }

    public List<Garaz> pokazGarazeUzytkownika(int idPerson) {
        List<Garaz> g = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Garaz.class) && entry.getValue() != null && entry.getValue().equals(idPerson)) {
                g.add((Garaz) entry.getKey());

            }

        }
        return g;


    }
    //metoda pokazujaca niewynajete  mieszkania zrodlo Mapa

    public List<Mieszkanie> pokazWolneMieszkania() {
        List<Mieszkanie> m = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Mieszkanie.class) && entry.getValue() == null) {
                m.add((Mieszkanie) entry.getKey());
            }

        }
        return m;
    }


    public List<Mieszkanie> czyZajeteM(List<Mieszkanie> m1) {
        List<Mieszkanie> m2 = new ArrayList<>();
        for (int k = 0; k < m1.size(); k++) {
            if (m1.get(k).getDataWynajecia() != null) {
                m1.remove(k);
            } else {
                m2.add(m1.get(k));
            }
        }
        return m2;
    }

    public List<Garaz> czyZajeteG(List<Garaz> g1) {
        List<Garaz> g2 = new ArrayList<>();
        for (int k = 0; k < g1.size(); k++) {
            if (g1.get(k).getDataWynajecia() != null) {
                g1.remove(k);
            } else {
                g2.add(g1.get(k));
            }
        }
        return g2;
    }


//metoda pokazujaca niewynajete  garaze zrodlo Mapa

    public List<Garaz> pokazWolneGaraze() {
        List<Garaz> g = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Garaz.class) && entry.getValue() == null) {
                g.add((Garaz) entry.getKey());
            }

        }
        return g;
    }


    //metody  pokazujaca  mieszkania/garaze ktore maja najemcow  zrodlo Mapa
    public List<Mieszkanie> pokazNieruchomosciM() {
        List<Mieszkanie> m = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Mieszkanie.class) && (entry.getValue() != null)) {
                m.add((Mieszkanie) entry.getKey());
            }
        }
        return m;
    }

    public List<Garaz> pokazNieruchomosciG() {
        List<Garaz> m = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Garaz.class) && (entry.getValue() != null)) {
                m.add((Garaz) entry.getKey());
            }
        }
        return m;
    }
// metody dla watku sprawdzajacego stan wynajec(czy przekroczony termin zakonczenia wynajmu) w obrebie osiedla, wysylaja File,koncza wynajem

    public void znajdzPrzedawnienieMieszkania(List<Mieszkanie> n, List<Person> persons) {
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i).getDataZakonczenia().isBefore(startDate.plusDays(t.getDay())) && n.get(i).getIdNajemcy() > 0) {

                File file = new File(n.get(i).toString(), n.get(i).getId());

                for (Person per : persons) {
                    if (per.getId() == n.get(i).getIdNajemcy()) {
                        per.getFileList().add(file);
                    }
                }
                n.get(i).usunIdNajemcy();
            } else if (n.get(i).getDataZakonczenia().plusDays(30).isBefore(startDate.plusDays(t.getDay())) && n.get(i).getIdNajemcy() == 0) {

                n.get(i).ustawDatyNull();
                n.get(i).getLokatorzy().clear();
                getWynajem().put(n.get(i), null);

                for (int w = 0; w < persons.size(); w++) {
                    if (persons.get(w).getId() == n.get(i).getIdNajemcy()) {
                        usunFileZListyUsera(persons.get(w), n.get(i).getId());

                    }
                }
                n.remove(i);

            }

        }
    }


    public void znajdzPrzedawnienieGarazu(List<Garaz> n, List<Person> persons) {
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i).getDataZakonczenia().isBefore(startDate.plusDays(t.getDay())) && n.get(i).getIdNajemcy() > 0) {

                File file = new File(n.get(i).toString(), n.get(i).getId());

                for (int w = 0; w < persons.size(); w++) {
                    if (persons.get(w).getId() == n.get(i).getIdNajemcy()) {
                        persons.get(w).getFileList().add(file);

                    }
                    n.get(i).usunIdNajemcy();
                }

            } else if (n.get(i).getDataZakonczenia().plusDays(30).isBefore(startDate.plusDays(t.getDay())) && n.get(i).getIdNajemcy() == 0) {

                n.get(i).ustawDatyNull();

                n.get(i).getItems().clear();

                for (int w = 0; w < persons.size(); w++) {
                    if (persons.get(w).getId() == n.get(i).getIdNajemcy()) {
                        usunFileZListyUsera(persons.get(w), n.get(i).getId());

                    }
                }

                getWynajem().put(n.get(i), null);

                n.remove(i);


            }
        }
    }

//metody do sprawdzenia czy przedluzenie wynajmu mieszkania/garazu mozna wykonac ze wzg na przekroczony termin konca wynajmu

    public List<Mieszkanie> czyPrzekroczonyTerminM(List<Mieszkanie> m1) {
        List<Mieszkanie> m2 = new ArrayList<>();
        for (int k = 0; k < m1.size(); k++) {
            if (m1.get(k).getDataZakonczenia().isBefore(startDate.plusDays(t.getDay()))) {
                m2.add(m1.get(k));
            } else {
                m1.remove(k);
            }
        }
        return m2;
    }

    public List<Garaz> czyPrzekroczonyTerminG(List<Garaz> g1) {
        List<Garaz> g2 = new ArrayList<>();
        for (int k = 0; k < g1.size(); k++) {
            if (g1.get(k).getDataZakonczenia().isBefore(startDate.plusDays(t.getDay()))) {
                g2.add(g1.get(k));
            } else {
                g1.remove(k);
            }
        }
        return g2;
    }

    public void usunFileZListyUsera(Person person, int id) {

        for (int i = 0; i < person.getFileList().size(); i++) {
            if (person.getFileList().get(i).getIdOsiedla() == id) {
                person.getFileList().remove(i);
            }

        }
    }

    public List<String> pobierzListeNieruchZFile(Person person) {
        List<String> osied = new ArrayList<>();
        for (File f : person.getFileList()) {
            osied.add(f.getOsiedle());
        }
        return osied;
    }


    public List<Mieszkanie> pokazListeMieszkanOsiedla() {
        List<Mieszkanie> m = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Mieszkanie.class)) {
                m.add((Mieszkanie) entry.getKey());
            }

        }
        Collections.sort(m);
        return m;


    }

    public List<Garaz> pokazListeGarazyOsiedla() {
        List<Garaz> g = new ArrayList<>();
        for (Map.Entry<Osiedle, Integer> entry : wynajem.entrySet()) {
            if (entry.getKey().getClass().equals(Garaz.class)) {
                g.add((Garaz) entry.getKey());
            }

        }
        Collections.sort(g);
        return g;


    }

    public String stringDoPliku(List<Mieszkanie> m, List<Garaz> g, List<Person> p) {
        String s = "";
        s = s + "Warszawa  dnia  " + startDate.plusDays(t.getDay()) + '\n' + '\n';
        s = s + "Lista Mieszkan" + '\n' + '\n';
        for (int i = 0; i < m.size(); i++) {
            for (int j = 0; j < p.size(); j++) {
                if (m.get(i).getIdNajemcy() == p.get(j).getId()) {
                    s = s + p.get(j) + '\n' + m.get(i) + '\n';
                }
            }
        }

        for (int k = 0; k < m.size(); k++)
            if (m.get(k).getIdNajemcy() == 0) {
                s = s + " mieszkanie niewynajete  :  " + m.get(k) + '\n';
            }


        s = s + '\n' + "Lista Garazy" + '\n' + '\n';

        for (int k = 0; k < g.size(); k++) {
            for (int j = 0; j < p.size(); j++) {
                if (g.get(k).getIdNajemcy() == p.get(j).getId()) {
                    s = s + p.get(j) + '\n' + g.get(k) + '\n';
                }
            }
        }
        for (int j = 0; j < g.size(); j++) {
            if (g.get(j).getIdNajemcy() == 0) {
                s = s + " garaz niewynajety  : " + g.get(j) + '\n';
            }

        }


        return s;
    }


    public void zapisDoPliku(String s, Osiedle os) throws Exception {


        BufferedWriter bw = null;


        try {
            bw = new BufferedWriter(new FileWriter("Stan osiedla.txt"));
            bw.write(s);


        } finally {
            if (bw != null)
                bw.close();
        }
    }
}













