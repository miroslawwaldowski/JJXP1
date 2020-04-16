package pl.Java_JSON_XML.JJXP1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileGenerator {

    public static void write(ArrayList<Resident> residents) {


        try {
            FileWriter fileWriter = new FileWriter(new File("file.txt"));

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Miasto; Imie; Nazwisko; PESEL");
            for (int i = 0; i < residents.size(); i++) {
                printWriter.println(residents.get(i).getCity() +
                        "; " + residents.get(i).getName() +
                        "; " + residents.get(i).getSurname() +
                        "; " + residents.get(i).getPesel());
            }

            printWriter.close();

        } catch (IOException e) {
            System.out.println("Blad zapisu pliku: " + e);
        }

    }
}
