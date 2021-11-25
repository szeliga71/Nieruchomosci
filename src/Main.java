import Exceptions.ProblematicTenantException;
import Exceptions.TooManyThingsException;
import items.*;
import osiedle.Garaz;
import osiedle.Mieszkanie;
import osiedle.Osiedle;
import servis.Service;
import servis.Time;
import users.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Time time = new Time();
        executorService.submit(time);
        LocalDate startDate = LocalDate.now();
        LocalDate currentDate = startDate.plusDays(time.getDay());


        //  podmioty i aktorzy
        Service service = new Service(time, startDate.plusDays(time.getDay()));

        Osiedle o1 = new Osiedle("Pod Jaworami", "Wroclaw", time, startDate.plusDays(time.getDay()));
        Osiedle o2 = new Osiedle("Pod Lipami", "Krakow", time, startDate.plusDays(time.getDay()));

        service.getOsiedla().add(o1);
        service.getOsiedla().add(o2);


        executorService.submit(service);


        Mieszkanie m1 = new Mieszkanie("Pod Jaworami", "Wroclaw", 1, 35, null, null, 0);
        Mieszkanie m2 = new Mieszkanie("Pod Jaworami", "Wroclaw", 2, 60, null, null, 0);
        Mieszkanie m3 = new Mieszkanie("Pod Jaworami", "Wroclaw", 3, 45, null, null, 0);
        Mieszkanie m4 = new Mieszkanie("Pod Jaworami", "Wroclaw", 4, 75, null, null, 0);
        Mieszkanie m5 = new Mieszkanie("Pod Jaworami", "Wroclaw", 5, 55, null, null, 0);
        Mieszkanie m6 = new Mieszkanie("Pod Jaworami", "Wroclaw", 6, 68, null, null, 0);
        Mieszkanie m7 = new Mieszkanie("Pod Jaworami", "Wroclaw", 7, 25, null, null, 0);
        Mieszkanie m8 = new Mieszkanie("Pod Jaworami", "Wroclaw", 8, 98, null, null, 0);
        Mieszkanie m9 = new Mieszkanie("Pod Jaworami", "Wroclaw", 9, 21, null, null, 0);
        Mieszkanie m10 = new Mieszkanie("Pod Jaworami", "Wroclaw", 10, 47, null, null, 0);
        Garaz g1 = new Garaz("Pod Jaworami", "Wroclaw", 1, 15, 3, null, null, 0);
        Garaz g2 = new Garaz("Pod Jaworami", "Wroclaw", 2, 16, 3, null, null, 0);
        Garaz g3 = new Garaz("Pod Jaworami", "Wroclaw", 3, 14, 3, null, null, 0);
        Garaz g4 = new Garaz("Pod Jaworami", "Wroclaw", 4, 17, 3, null, null, 0);
        Garaz g5 = new Garaz("Pod Jaworami", "Wroclaw", 5, 13, 3, null, null, 0);
        Garaz g6 = new Garaz("Pod Jaworami", "Wroclaw", 6, 19, 3, null, null, 0);

        service.getPersons().add(new Person("Jan", "Kowalski", "7509308856", "30-09-1975", "Warszawa"));
        service.getPersons().add(new Person("Piotr", "Nowak", "7307159935", "15-07-1973", "Poznan"));
        service.getPersons().add(new Person("Tadeusz", "Konopka", "7509109815", "10-09-1975", "Szczecin"));
        service.getPersons().add(new Person("Jerzy", "Milewski", "7108107777", "10-08-1971", "Piotrkow Trybunalski"));
        service.getPersons().add(new Person("Albert", "Wisniak", "8504112211", "11-04-1985", "Koszalin"));
        service.getPersons().add(new Person("Mateusz", "Lewak", "8202199815", "19-02-1982", "Lublin"));

        // wsadzenie mieszkan i garazy do Mapy

        service.getOsiedla().get(0).getWynajem().put(m1, null);
        service.getOsiedla().get(0).getWynajem().put(m2, null);
        service.getOsiedla().get(0).getWynajem().put(m3, null);
        service.getOsiedla().get(0).getWynajem().put(m4, null);
        service.getOsiedla().get(0).getWynajem().put(m5, null);
        service.getOsiedla().get(0).getWynajem().put(m6, null);
        service.getOsiedla().get(0).getWynajem().put(m7, null);
        service.getOsiedla().get(0).getWynajem().put(m8, null);
        service.getOsiedla().get(0).getWynajem().put(m9, null);
        service.getOsiedla().get(0).getWynajem().put(m10, null);

        service.getOsiedla().get(0).getWynajem().put(g1, null);
        service.getOsiedla().get(0).getWynajem().put(g2, null);
        service.getOsiedla().get(0).getWynajem().put(g3, null);
        service.getOsiedla().get(0).getWynajem().put(g4, null);
        service.getOsiedla().get(0).getWynajem().put(g5, null);
        service.getOsiedla().get(0).getWynajem().put(g6, null);


        //  przedmioty

        Items it1 = new Item("kosiarka", 1.0, 1.0, 0.5);
        Items it2 = new Item("grill", 1.0, 2.0, 1.7);
        Items it3 = new Item("hustawka", 2.0, 1.5, 2.5);
        Pojazd it4 = new AutoTerenowe("Land Rover", 2.0, 5.0, 2.0, "Terrano", RodzajPaliwa.DIESEL, Naped.FOURWHEELDRIVE);
        Pojazd it5 = new AutoMiejskie("BMW", 1.8, 4, 1.5, "x1", RodzajPaliwa.ELEKTRYCZNY, Naped.KOLA);
        Pojazd it6 = new Motocykl("Suzuki", 0.8, 2.0, 1.3, "samuraj", RodzajPaliwa.BENZYNA, Naped.KOLA);
        Pojazd it7 = new Lodz(" Orion", 3, 6, 3, RodzajPaliwa.WIATR, Naped.ZAGIEL);

        //  przypisanie  do uzytkownikow przedmiotow

        service.getPersons().get(0).getItems().add(it1);
        service.getPersons().get(0).getItems().add(it4);
        service.getPersons().get(0).getItems().add(it6);
        service.getPersons().get(0).getItems().add(it7);
        service.getPersons().get(1).getItems().add(it3);
        service.getPersons().get(1).getItems().add(it6);
        service.getPersons().get(2).getItems().add(it5);
        service.getPersons().get(2).getItems().add(it2);


        menu();
        System.out.println();

        Scanner scan = new Scanner(System.in);

        String opcja = "0";
        Person uzytkownik = null;
        Osiedle osiedle = null;
        boolean dalej;
        Mieszkanie mieszkanie = null;
        Garaz garaz = null;

        while (!opcja.equals("21")) {

            System.out.println();
            System.out.println("       MENU GLOWNE" + '\n');
            System.out.println(" Pozycja '19' wyswietlenie MENU " + '\n');
            System.out.print(" Wybierz opcje :" + '\n');


            opcja = scan.nextLine();

            switch (opcja) {

                case "1":

                    System.out.println("Prosze wybrac Osiedle " + '\n');
                    wyswietlListe(service.getOsiedla());
                    dalej = true;
                    while (dalej) {
                        int wyb = wybor();
                        if (wyb >= 1 && wyb <= service.getOsiedla().size()) {
                            osiedle = service.getOsiedla().get(wyb - 1);
                            dalej = false;
                        } else {
                            System.out.println("Nie ma pod wpisanym znakiem zadnego obiektu  " + '\n');
                        }
                    }
                    break;

                case "2":

                    System.out.println("Uzytkownicy :" + '\n');
                    wyswietlListe(service.getPersons());
                    uzytkownik = wyborOsoby(service.getPersons().size(), service.getPersons());

                    break;
                case "3":
                    if (uzytkownikNull(uzytkownik)) {
                    } else
                        System.out.println("" + uzytkownik + '\n');
                    System.out.println("Czy zmienic lub zalogowac  uzytkownika ?  [1] TAK/ [ kazdy inny klawisz ] NIE ");
                    String wybor = scan.nextLine();
                    if (wybor.equals("1")) {
                        uzytkownik = null;
                        System.out.println("uzytkownik zostal wylogowany !" + '\n');
                    } else {
                        if (uzytkownik == null) {
                            System.out.println("Prosze zalogowac sie jako nowy uzytkownik !" + '\n');
                        } else
                            System.out.println("Jestes zalogowany jako :" + uzytkownik + '\n');
                    }

                    break;
                case "4":
                    if (!osiedle.czyZajeteM(osiedle.pokazWolneMieszkania()).isEmpty()) {
                        System.out.println(" wolne mieszkania do wynajecia " + '\n');
                        wyswietlListe(osiedle.czyZajeteM(osiedle.pokazWolneMieszkania()));
                    } else {
                        System.out.println("brak wolnch mieszkan " + '\n');
                    }

                    break;
                case "5":
                    if (!osiedle.czyZajeteG(osiedle.pokazWolneGaraze()).isEmpty()) {
                        System.out.println(" wolne garaze do wynajecia " + '\n');
                        wyswietlListe(osiedle.czyZajeteG(o1.pokazWolneGaraze()));
                    } else {
                        System.out.println("brak wolnch garazy " + '\n');
                    }

                    break;
                case "6":

                    if (uzytkownikNull(uzytkownik)) {

                    } else if ((osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size() +
                            osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) >= 5) {
                        System.out.println(" uzytkownik nie moze wynajac kolejnego mieszkania poniewaz ilosc jego kontraktow jest rowna 5");
                        System.out.println("nacisnij enter ");
                        scan.nextLine();
                    } else {
                        System.out.println("wynajecie mieszkania");
                        if (!osiedle.czyZajeteM(osiedle.pokazWolneMieszkania()).isEmpty()) {
                            wyswietlListe(osiedle.czyZajeteM(osiedle.pokazWolneMieszkania()));
                            dalej = true;
                            while (dalej) {
                                int wyb = wybor();
                                if (wyb >= 1 && wyb <= osiedle.czyZajeteM(osiedle.pokazWolneMieszkania()).size()) {
                                    mieszkanie = osiedle.pokazWolneMieszkania().get(wyb - 1);
                                    try {
                                        osiedle.najemM(mieszkanie, uzytkownik);
                                    } catch (ProblematicTenantException e) {
                                    }
                                    dalej = false;
                                } else {
                                    System.out.println("Nie ma pod wpisanym znakiem zadnego mieszkania ");
                                }
                            }
                        } else {
                            System.out.println("nie ma wolnych mieszkan do wynajecia");
                        }
                    }
                    break;
                case "7":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println("uzytkownik nie ma jeszcze wynajetego zadnego mieszkania ");
                    } else if ((osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size() +
                            osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) >= 5) {
                        System.out.println(" uzytkownik nie moze wynajac kolejnego garazu poniewaz ilosc jego kontraktow jest rowna 5");
                        System.out.println("nacisnij enter ");
                        scan.nextLine();
                    } else {
                        System.out.println("wynajecie garazu ");
                        if (!osiedle.czyZajeteG(osiedle.pokazWolneGaraze()).isEmpty()) {
                            wyswietlListe(osiedle.czyZajeteG(osiedle.pokazWolneGaraze()));

                            dalej = true;
                            while (dalej) {
                                int wyb = wybor();
                                if (wyb >= 1 && wyb <= osiedle.czyZajeteG(osiedle.pokazWolneGaraze()).size()) {
                                    garaz = osiedle.pokazWolneGaraze().get(wyb - 1);
                                    try {
                                        osiedle.najemG(garaz, uzytkownik);
                                    } catch (ProblematicTenantException e) {

                                    }
                                    dalej = false;
                                } else {
                                    System.out.println("Nie ma pod wpisanym znakiem zadnego garazu ");
                                }
                            }
                        } else {
                            System.out.println("nie ma wolnych garazy  do wynajecia");
                        }
                    }


                    break;
                case "8":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych mieszkan " + '\n');
                    } else {
                        System.out.println("lista mieszkan uzytkownika " + uzytkownik + '\n');

                        wyswietlListe(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()));

                        dalej = true;

                        while (dalej) {
                            int wyb = wybor();
                            if (wyb >= 1 && wyb <= osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()) {
                                mieszkanie = osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).get(wyb - 1);
                                mieszkanie.getLokatorzy().clear();
                                mieszkanie.usunIdNajemcy();
                                mieszkanie.ustawDatyNull();
                                osiedle.usunFileZListyUsera(uzytkownik, mieszkanie.getId());
                                osiedle.getWynajem().put(mieszkanie, null);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego mieszkania  ");

                            }
                        }
                    }

                    break;
                case "9":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze przekroczonych terminow  ");
                    } else {

                        System.out.println("lista mieszkan uzytkownika " + uzytkownik);
                        wyswietlListe(osiedle.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())));

                        dalej = true;
                        while (dalej) {
                            int wyb = wybor();
                            if (wyb >= 1 && wyb <= o1.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())).size()) {
                                mieszkanie = osiedle.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())).get(wyb - 1);
                                mieszkanie.ustawDaty(startDate.plusDays(time.getDay()));
                                osiedle.usunFileZListyUsera(uzytkownik, mieszkanie.getId());
                                osiedle.getWynajem().put(mieszkanie, uzytkownik.getId());

                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego mieszkania  ");

                            }
                        }
                    }
                    break;

                case "10":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych garazy ");
                    } else {
                        System.out.println("lista garazy uzytkownika " + uzytkownik);
                        wyswietlListe(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));

                        dalej = true;
                        while (dalej) {
                            int wyb = wybor();
                            if (wyb >= 1 && wyb <= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) {
                                garaz = osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb - 1);

                                for (Items item : garaz.getItems()) {
                                    uzytkownik.getItems().add(item);
                                }
                                garaz.getItems().clear();
                                garaz.usunIdNajemcy();
                                garaz.ustawDatyNull();
                                osiedle.usunFileZListyUsera(uzytkownik, garaz.getId());
                                osiedle.getWynajem().put(garaz, null);

                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnych wolnych garazy  ");

                            }
                        }
                    }


                    break;


                case "11":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze przekroczonych terminow  ");
                    } else {

                        System.out.println("lista garazy uzytkownika " + uzytkownik);
                        wyswietlListe(osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())));


                        dalej = true;
                        while (dalej) {
                            int wyb = wybor();
                            if (wyb >= 1 && wyb <= osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())).size()) {
                                garaz = osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())).get(wyb - 1);
                                garaz.ustawDaty(startDate.plusDays(time.getDay()));
                                osiedle.usunFileZListyUsera(uzytkownik, garaz.getId());
                                osiedle.getWynajem().put(garaz, uzytkownik.getId());

                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu  ");

                            }
                        }
                    }


                    break;


                case "12":

                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych mieszkan ");
                    } else {
                        System.out.println("lista mieszkan uzytkownika " + uzytkownik);
                        wyswietlListe(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()));

                        dalej = true;
                        while (dalej) {
                            int wyb = wybor();
                            if (wyb >= 1 && wyb <= osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()) {
                                mieszkanie = osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).get(wyb - 1);

                                System.out.println(" Lista osob");
                                int v = 0;
                                for (Person per : service.getPersons()) {
                                    v++;
                                    System.out.println(v + "." + " " + per.toString());
                                }
                                osiedle.zamelduj(mieszkanie, wyborOsoby(service.getPersons().size(), service.getPersons()));

                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego miwszkania  ");

                            }
                        }


                    }


                    break;
                case "13":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych mieszkan ");
                    } else {
                        System.out.println("lista mieszkan uzytkownika " + uzytkownik);
                        wyswietlListe(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()));

                        dalej = true;

                        while (dalej) {
                            int wyb = wybor();
                            if (wyb >= 1 && wyb <= osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()) {
                                mieszkanie = osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).get(wyb - 1);
                                dalej = false;

                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego mieszkania  ");
                            }
                        }


                        if (mieszkanie.getLokatorzy().isEmpty()) {
                            System.out.println("w mieszkaniu nie ma zameldowanych zadnych lokatorow ");
                        } else {

                            System.out.println(" wybierz osobe ktora chcesz wymeldowac ");

                            int z = 0;
                            for (Object per : mieszkanie.getLokatorzy().toArray()) {
                                z++;
                                System.out.println(z + "." + " " + per.toString());
                            }


                            dalej = true;

                            while (dalej) {
                                int wyb1 = wybor();

                                if (wyb1 >= 1 && wyb1 <= mieszkanie.getLokatorzy().size()) {
                                    Person p = (Person) mieszkanie.getLokatorzy().toArray()[wyb1 - 1];
                                    mieszkanie.getLokatorzy().remove(p);
                                    dalej = false;
                                }

                            }
                        }
                    }


                    break;


                case "14":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych garazy ");
                    } else {
                        System.out.println("lista garazy uzytkownika " + uzytkownik);
                        wyswietlListe(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));

                        System.out.println(" wybierz garaz do  ktorego chcesz wlozyc przedmiot  ");

                        dalej = true;

                        while (dalej) {
                            int wyb1 = wybor();

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) {
                                garaz = osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb1 - 1);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                            }
                        }


                        if (uzytkownik.getItems().isEmpty()) {

                            System.out.println("wszystkie przedmioty uzytkownika zostaly rozmieszczone w wynajetych garazach lub uzytkownik nie posiada zadnych przedmiotow ");
                        } else {
                            System.out.println(" wybierz ktory przedmiot chcesz wlozyc do wybranego garazu ");
                            int z = 0;
                            for (Object item : uzytkownik.getItems().toArray()) {
                                z++;
                                System.out.println(z + "." + " " + item.toString());
                            }


                            dalej = true;
                            while (dalej) {
                                int wyb2 = wybor();

                                if (wyb2 >= 1 && wyb2 <= uzytkownik.getItems().size()) {
                                    Items it = (Items) uzytkownik.getItems().toArray()[wyb2 - 1];
                                    dalej = false;

                                    try {
                                        garaz.wlozDoGarazu(garaz, it, uzytkownik);
                                    } catch (TooManyThingsException e) {
                                    }
                                }
                            }


                        }

                    }
                    break;
                case "15":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych garazy ");
                    } else {
                        System.out.println("lista garazy uzytkownika " + uzytkownik);
                        wyswietlListe(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));


                        System.out.println(" wybierz garaz z ktorego chcesz wyjac przedmiot  ");

                        dalej = true;

                        while (dalej) {
                            int wyb1 = wybor();

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) {
                                garaz = osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb1 - 1);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                            }
                        }


                        System.out.println(" wybierz ktory przedmiot chcesz wyjac z wybranego garazu ");


                        int z = 0;
                        for (Object item : garaz.getItems().toArray()) {
                            z++;
                            System.out.println(z + "." + " " + item.toString());
                        }

                        dalej = true;
                        while (dalej) {
                            int wyb2 = wybor();

                            if (wyb2 >= 1 && wyb2 <= uzytkownik.getItems().size()) {
                                Items it = (Items) garaz.getItems().toArray()[wyb2 - 1];
                                garaz.getItems().remove(it);
                                uzytkownik.getItems().add(it);
                                dalej = false;
                            }

                        }
                    }


                    break;
                case "16":

                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych mieszkan ");
                    } else {
                        System.out.println("lista mieszkan uzytkownika " + uzytkownik);

                        wyswietlListe(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()));

                        System.out.println(" wybierz mieszkanie w ktorym chcesz sprawdzic liste zameldowanych osob  ");

                        dalej = true;

                        while (dalej) {
                            int wyb1 = wybor();

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()) {
                                mieszkanie = osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).get(wyb1 - 1);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                            }
                        }


                        int z = 0;
                        for (Object per : mieszkanie.getLokatorzy().toArray()) {
                            z++;
                            System.out.println(z + "." + " " + per.toString());
                        }
                    }
                    break;
                case "17":

                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).isEmpty()) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych garazy ");
                    } else {
                        System.out.println("lista garazy uzytkownika " + uzytkownik);

                        wyswietlListe(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));

                        System.out.println(" wybierz garaz w ktorym chcesz sprawdzic liste umieszczonych w nim przedmiotow  ");


                        dalej = true;

                        while (dalej) {
                            int wyb1 = wybor();

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) {
                                garaz = osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb1 - 1);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                            }
                        }

                        if (garaz.getItems().isEmpty()) {
                            System.out.println(" w garazu nie ma zadnych przedmiotow ");
                        } else {
                            int z = 0;
                            for (Object per : garaz.getItems().toArray()) {
                                z++;
                                System.out.println(z + "." + " " + per.toString());
                            }


                        }
                    }

                    break;
                case "18":


                    if (osiedle == null) {
                        System.out.println(" prosze wybrac osiedle ");
                    } else {
                        System.out.println(" nastapil zapis informacji o osiedlu " + osiedle + " do pliku " + '\n');
                        osiedle.zapisDoPliku(osiedle.stringDoPliku(osiedle.pokazListeMieszkanOsiedla(), osiedle.pokazListeGarazyOsiedla(), service.getPersons()), osiedle);
                    }


                    break;


                case "19":
                    menu();
                    break;
                case "20":
                    System.out.println("Czy wylogowac  uzytkownika ?  [1] TAK / [ kazdy inny klawisz ] Powrot do MENU GLOWNEGO  ");
                    String wybierz = scan.nextLine();
                    if (wybierz.equals("1")) {
                        uzytkownik = null;
                        System.out.println("uzytkownik zostal wylogowany !" + '\n');
                        System.out.println("nacisnij dowolny klawisz aby przejsc do MENU GLOWNEGO ! ");
                        scan.nextLine();
                    }
                    break;
                case "21":
                    time.setRozrusznik(false);
                    service.setRozrusznik1(false);
                    executorService.shutdown();
                    System.out.println("Zakonczenie programu ");
                    break;
                default:
                    System.out.println("PROSZE PODAC WLASCIWA OPCJE !");

            }
        }


    }


    public static void menu() {

        System.out.println();

        System.out.println();
        System.out.println("Prosze wybrac nastepujaca opcje :");
        System.out.println(" 1: wybor osiedla ");
        System.out.println(" 2: wskazanie osoby  ");
        System.out.println(" 3: wypisanie danych osobowych uzytkownika ");
        System.out.println(" 4: wyswietlenie wolnych mieszkan ");
        System.out.println(" 5: wyswietlenie wolnych garazy ");
        System.out.println(" 6: wynajecie mieszkania( po uprzednim wybraniu) ");
        System.out.println(" 7: wynajecie garazu ");
        System.out.println(" 8: rezygnacja z najmu mieszkania");
        System.out.println(" 9: przedluzenie najmu mieszkania");
        System.out.println(" 10: rezygnacja z najmu garazu");
        System.out.println(" 11: przedluzenie najmu garazu");
        System.out.println(" 12: zameldowanie  nowego lokatora w mieszkaniu ");
        System.out.println(" 13: wymeldowanie lokatora z mieszkania");
        System.out.println(" 14: wlozenie nowych przedmiotow do garazu ");
        System.out.println(" 15: wyjecie przedmiotow z garazu ");
        System.out.println(" 16: pokazanie mieszkania ktore wynajmuje dana osoba i wyswietlenie jego lokatorow ");
        System.out.println(" 17: pokazanie garazy uzytkownika i umieszczonych w nich przedmiotow ");
        System.out.println(" 18: zapis stanu aplikacji do pliku");
        System.out.println(" 19: wyswietlenie menu");
        System.out.println(" 20: wylogowanie uzytkownika ");
        System.out.println(" 21: zakonczenie programu");
        System.out.println();
    }

    public static Person wyborOsoby(int size, List<Person> per) {
        Person p = null;
        boolean dalej = true;

        while (dalej) {

            System.out.println("Prosze wybarc uzytkownika/osobe :");
            Scanner scan = new Scanner(System.in);
            String text = scan.nextLine();
            int nrUzytkownika = 0;
            try {
                nrUzytkownika = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Prosze podac liczbe odnoszaca sie do osoby ");
            }

            if (nrUzytkownika >= 1 && nrUzytkownika <= size) {
                p = per.get(nrUzytkownika - 1);
                dalej = false;
            } else {
                System.out.println("Nie ma pod wpisanym znakiem zadnego uzytkownika ");

            }
        }
        return p;
    }


    public static boolean uzytkownikNull(Person person) {
        Scanner scan1 = new Scanner(System.in);
        boolean uNull = false;
        if (person == null) {
            uNull = true;
            System.out.println("musisz byc zalogowany ");
            System.out.println("nacisnij enter ");
            scan1.nextLine();
        } else {
            System.out.println(" jestes zalogowany jako " + person);

        }

        return uNull;
    }

    public static void wyswietlListe(List p) {

        for (int i = 0; i < p.size(); i++) {

            System.out.println((i + 1) + "." + " " + p.get(i));
        }
    }

    public static int wybor() {

        int wybor = 0;
        boolean dalej = true;
        Scanner scan = new Scanner(System.in);


        while (dalej) {

            System.out.println(" wybierz  odpowiednia opcje  ");

            String text = scan.nextLine();

            try {
                wybor = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
            }
            dalej = false;
        }

        return wybor;
    }

}



