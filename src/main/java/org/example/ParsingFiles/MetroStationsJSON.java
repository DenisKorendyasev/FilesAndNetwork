package org.example.ParsingFiles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetroStationsJSON {

    private String name;
    private double depthStation;

    public MetroStationsJSON(String nameStation, double depthStation) {
        this.name = nameStation;
        this.depthStation = depthStation;
    }

    @Override
    public String toString() {
        return "Название станции: " + name +
                "  Глубина станции: " + depthStation;
    }
}
