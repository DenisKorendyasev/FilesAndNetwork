package org.example.ParsingFiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;

public class ParsingJsonFile {

    ArrayList<MetroStationsJSON> stationsList = new ArrayList<>();


    public ArrayList<MetroStationsJSON> getStationsList(String path) throws IOException
    {
        String json = Files.readString(Paths.get(path));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode stationsJson = objectMapper.readValue(json, JsonNode.class);

        for (JsonNode node : stationsJson)
        {
            String name = String.valueOf(node.get("station_name"));
            name = name.replaceAll("\"", "");

            String depth = String.valueOf(node.get("depth"));
            depth = depth.replaceAll("\"", "").replace("?", "0");
            depth = depth.replaceAll(",",".");
            stationsList.add(new MetroStationsJSON(name, Double.parseDouble(depth)));
        }
        return stationsList;
    }
}
