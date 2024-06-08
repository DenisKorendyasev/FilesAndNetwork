package org.example.CreatingJsonFiles;

import org.example.ParsingFiles.MetroStationsCSV;
import org.example.ParsingFiles.MetroStationsJSON;
import org.example.ParsingHTML.LinesMetro;
import org.example.ParsingHTML.MetroStations;

import java.util.*;

public class MergeData {
    public List<Station> mergeStationData(List<MetroStations> stations, List<MetroStationsJSON> depths,
                                          List<MetroStationsCSV> dates, List<LinesMetro> linesMetros)
    {
        Map<String, Station> stationMap = new HashMap<>();

        for (MetroStations metroStation : stations)
        {
            Station station = new Station();
            for (LinesMetro lines : linesMetros){
                if (metroStation.getNumber().equals(lines.getNumber())){
                    station.setLine(lines.getName());
                }
            }
            station.setName(metroStation.getName());
            station.setHasConnection(metroStation.isHasConnection());
            stationMap.put(metroStation.getName(), station);
        }

        for (MetroStationsJSON depth : depths)
        {
            String stationName = depth.getName().toLowerCase(Locale.ROOT).replace("\u0451", "\u0435");
            if (stationMap.containsKey(stationName)) {
                stationMap.get(stationName).setDepth(depth.getDepthStation());
            }
        }

        for (MetroStationsCSV date : dates)
        {
            String station1Name = date.getName().toLowerCase(Locale.ROOT).replace("\u0451", "\u0435");
            if (stationMap.containsKey(station1Name)) {
                stationMap.get(station1Name).setDate(date.getDate());
            }
        }

        return new ArrayList<>(stationMap.values());
    }
}
