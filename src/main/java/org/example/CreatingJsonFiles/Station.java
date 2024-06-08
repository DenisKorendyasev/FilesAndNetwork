package org.example.CreatingJsonFiles;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Station {
    private String name;
    private String line;
    private String date;
    private double depth;
    private boolean hasConnection;


    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", date='" + date + '\'' +
                ", depth=" + depth +
                ", hasConnection=" + hasConnection +
                '}';
    }
}

