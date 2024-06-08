package org.example.CreatingJsonFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ParsingHTML.LinesMetro;
import org.example.ParsingHTML.MetroStations;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddingFiles {

    public void creatingFirstFile(String path, List<Station> stations) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String twoFileJson = objectMapper.writeValueAsString(stations);
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(twoFileJson);
        fileWriter.close();
    }

    public void creatingSecondFile(String path, List<LinesMetro> linesMetro , List<MetroStations> stations) throws IOException {

        HashMap<String, List<String>> station = new HashMap<>();
        for (MetroStations metro : stations)
        {
            List<String> str = new ArrayList<>();
            String number = metro.getNumber();
            station.put(number, str);
            if (station.containsKey(number))
            {
                for (MetroStations metroStations : stations)
                {
                    if (metroStations.getNumber().equals(metro.getNumber())) {
                        str.add(metroStations.getName());
                    }
                }
                station.put(number, str);
            }

        }

        ObjectMapper objectMapper = new ObjectMapper();
        String oneJson = objectMapper.writeValueAsString(station);
        String twoJson = objectMapper.writeValueAsString(linesMetro);
        FileWriter fileWriterOne = new FileWriter(path);
        fileWriterOne.write(oneJson);
        fileWriterOne.write(twoJson);
        fileWriterOne.close();

    }


}
