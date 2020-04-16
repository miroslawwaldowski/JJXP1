package pl.Java_JSON_XML.JJXP1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileGeneratorTest {

    @Before
    public void setUp() {
        ArrayList<Resident> list = new ArrayList<>();
        Resident resident1 = new Resident("A", "A", "A", "71072845657");
        Resident resident2 = new Resident("B", "B", "B", "51052438673");
        list.add(resident1);
        list.add(resident2);
        FileGenerator.write(list);

    }


    @Test
    public void testWrite() {


        try {
            FileInputStream fis = new FileInputStream("file.txt");
            Scanner sc = new Scanner(fis);

            String one = sc.nextLine();
            String two = sc.nextLine();
            String three = sc.nextLine();

            Assert.assertEquals("Miasto; Imie; Nazwisko; PESEL", one);
            Assert.assertEquals("A; A; A; 71072845657", two);
            Assert.assertEquals("B; B; B; 51052438673", three);


            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}