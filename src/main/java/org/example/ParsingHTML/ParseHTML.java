package org.example.ParsingHTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ParseHTML {
    private String URL = "https://skillbox-java.github.io/";

    public List<LinesMetro> getLinesMetro() throws IOException
    {
        Document document = Jsoup.connect(URL).get();
        var elementsLinesMetro = document.select("span.js-metro-line");
        List<LinesMetro> listLinesMetro= new ArrayList<>();
        for (Element element : elementsLinesMetro)
        {
            listLinesMetro.add(new LinesMetro(
                    element.text(),
                    element.attr("data-line"))
            );
        }
        return listLinesMetro;
    }

    public List<MetroStations> getMetroStations() throws IOException
    {
        Document document = Jsoup.connect(URL).get();
        var numbersLine = document.select("p.single-station");
        List<MetroStations> metroStations = new ArrayList<>();

        for (Element element : numbersLine)
        {
            MetroStations stations = new MetroStations();

            String name = element.getElementsByClass("name").text();

            stations.setName(name.toLowerCase(Locale.ROOT).replace("\u0451", "\u0435"));
            stations.setNumber(element.parent().attr("data-line"));

            if (element.getElementsByAttribute("title").attr("title") != "")
            {
                stations.setHasConnection(true);
            } else {
                stations.setHasConnection(false);
            }
            metroStations.add(stations);

        }
        return metroStations;
    }
}

