package org.example.ParsingHTML;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ParseHTML parseHTML = new ParseHTML();
        try {
            System.out.println("Линии метро");
            parseHTML.getLinesMetro().forEach(System.out::println);
            System.out.println("\n" + "Станции метро");
            parseHTML.getMetroStations().forEach(System.out::println);
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }
}
