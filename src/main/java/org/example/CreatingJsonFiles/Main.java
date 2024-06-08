package org.example.CreatingJsonFiles;

import org.example.ParsingFiles.MetroStationsCSV;
import org.example.ParsingFiles.MetroStationsJSON;
import org.example.ParsingFiles.ParsingCsvFile;
import org.example.ParsingFiles.ParsingJsonFile;
import org.example.ParsingHTML.LinesMetro;
import org.example.ParsingHTML.MetroStations;
import org.example.ParsingHTML.ParseHTML;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

//        Получаю лист стацний и линий при парсиенге html страницы
        ParseHTML parseHTML = new ParseHTML();
        List<MetroStations> metroStationsList = parseHTML.getMetroStations();
        List<LinesMetro> linesMetro = parseHTML.getLinesMetro();

//        Получаю лист с станицями и датой открытия
        ParsingCsvFile parsingCsv = new ParsingCsvFile();
        String pathCSV = "FilesAndNetwork\\DataCollector\\folders\\stations-data\\data\\9\\6\\dates-3.csv";
        List<MetroStationsCSV> metroCSV = parsingCsv.getStationsList(pathCSV);

//        Получаю лист с станиями и глубиной
        ParsingJsonFile parsingJson = new ParsingJsonFile();
        String pathJSON = "FilesAndNetwork\\DataCollector\\folders\\stations-data\\data\\2\\4\\depths-1.json";
        List<MetroStationsJSON> metroJSON = parsingJson.getStationsList(pathJSON);


//       Получаю лсит объектов, для записи в json
        MergeData mergeData = new MergeData();
        List<Station> stations = mergeData.mergeStationData(metroStationsList, metroJSON, metroCSV, linesMetro);

//        Записи в файл формата Json
        String firstFilePath = "C:\\skillbox\\java_ds19\\FilesAndNetwork\\DataCollector\\TwoJsonFiles\\stations.json";
        String secondFilePath = "C:\\skillbox\\java_ds19\\FilesAndNetwork\\DataCollector\\TwoJsonFiles\\oneFile.json";
        AddingFiles addingFiles = new AddingFiles();
        addingFiles.creatingFirstFile(firstFilePath, stations);
        addingFiles.creatingSecondFile(secondFilePath, linesMetro, metroStationsList);


    }
}
