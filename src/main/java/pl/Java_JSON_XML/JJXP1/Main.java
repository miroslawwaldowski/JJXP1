package pl.Java_JSON_XML.JJXP1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static List<Resident> residentList = new ArrayList<>();


    public static void main(String[] args) {


        read();
        FileGenerator.write((ArrayList<Resident>) residentList);
        System.out.println(residentList.size());

    }

    public static void read() {

        boolean next = true;

        while (next) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Podaj miasto: ");
            String city = scan.nextLine();
            System.out.println("Podaj imie: ");
            String name = scan.nextLine();
            System.out.println("Podaj nazwisko: ");
            String surname = scan.nextLine();
            System.out.println("Podaj PESEL: ");

            boolean wrongPesel = true;

            while (wrongPesel) {

                String pesel = scan.nextLine();
                //sprawdza pesel
                if (PeselCheck.check(pesel)) {

                    wrongPesel = false;
                    //sprawdza czy lista jest pusta
                    if (residentList.size() == 0) {
                        Resident resident = new Resident(city, name, surname, pesel);
                        residentList.add(resident);
                    } else {
                        //sprawdza czy pesel jest już w liście
                        for (int i = 0; i < residentList.size(); i++) {
                            if (residentList.get(i).getPesel().equals(pesel)) {
                                residentList.get(i).setCity(city);
                                residentList.get(i).setName(name);
                                residentList.get(i).setSurname(surname);
                                //break;
                            } else {
                                Resident resident = new Resident(city, name, surname, pesel);
                                residentList.add(resident);
                            }
                        }
                    }

                } else {
                    System.out.println("PESEL niepoprawny, podaj poprawny PESEL");
                }
            }

            boolean wrongAnswer = true;
            while (wrongAnswer) {
                System.out.println("Następna osoba?(t/n)");
                String n = scan.nextLine().toLowerCase();
                if (n.equals("n")) {
                    next = false;
                    wrongAnswer = false;
                } else if (n.equals("t")) {
                    next = true;
                    wrongAnswer = false;
                } else {
                    wrongAnswer = true;
                    System.out.println("Podaj poprawną odpowiedź");
                }
            }
        }
    }
}
