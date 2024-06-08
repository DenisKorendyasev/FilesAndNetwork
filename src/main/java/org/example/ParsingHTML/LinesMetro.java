package org.example.ParsingHTML;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LinesMetro {
    private String name;
    private String number;


    public LinesMetro(String nameLines, String numberLines) {
        this.name = nameLines;
        this.number = numberLines;
    }

    @Override
    public String toString() {
        return "Линия метро: " + name + ". " + "Номер линии: " + number;
    }
}
