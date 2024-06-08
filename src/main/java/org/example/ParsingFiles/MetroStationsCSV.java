package org.example.ParsingFiles;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"name", "date"})
public class MetroStationsCSV {

     String name;
     String date;


    @Override
    public String toString() {
        return "Название станции: " + name +
                "  Дата открытия: " + date;
    }
}

