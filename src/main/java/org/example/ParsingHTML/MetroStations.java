package org.example.ParsingHTML;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetroStations {
    private String name;
    private String number;
    private boolean hasConnection;





    @Override
    public String toString()
    {
        return  "Название станции: " + name +
                " Номер линии: " + number +
                " Переход: " + (hasConnection ? "Есть" : "Нет");
    }
}
