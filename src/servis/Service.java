package servis;

import osiedle.Osiedle;
import users.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service implements Runnable {


    Time t;
    LocalDate startDate;

    boolean rozrusznik1 = true;

    List<Person> persons;
    List<Osiedle> osiedla;


    public Service(Time t, LocalDate startDate) {
        this.t = t;
        this.startDate = startDate;
        osiedla = new ArrayList<>();
        persons = new ArrayList<>();

    }


    @Override
    public void run() {


        while (rozrusznik1) {

            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < osiedla.size(); i++) {

                osiedla.get(i).znajdzPrzedawnienieMieszkania(osiedla.get(i).pokazNieruchomosciM(), getPersons());

                osiedla.get(i).znajdzPrzedawnienieGarazu(osiedla.get(i).pokazNieruchomosciG(), getPersons());
            }
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Osiedle> getOsiedla() {
        return osiedla;
    }

    public void setRozrusznik1(boolean rozrusznik1) {
        this.rozrusznik1 = rozrusznik1;
    }
}
