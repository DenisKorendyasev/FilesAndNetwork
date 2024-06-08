package org.example.ParsingFiles;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        String pathJSON = "FilesAndNetwork\\DataCollector\\folders\\stations-data\\data\\2\\4\\depths-1.json";
        String pathCSV = "FilesAndNetwork\\DataCollector\\folders\\stations-data\\data\\9\\6\\dates-3.csv";

        System.out.println("Чтение из файла  с расширение .json");
        ParsingJsonFile stationsJSON = new ParsingJsonFile();
        stationsJSON.getStationsList(pathJSON).forEach(System.out::println);

        System.out.println("\n" + "Чтение из файла  с расширение .csv");
        ParsingCsvFile stationsCSV = new ParsingCsvFile();
        stationsCSV.getStationsList(pathCSV).forEach(System.out::println);

    }
}
