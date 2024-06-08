package org.example.ParsingFiles;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class ParsingCsvFile {

    public  List<MetroStationsCSV> getStationsList(String path) throws IOException
    {
        Reader myReader = new FileReader(path);
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema =
                mapper
                .schemaFor(MetroStationsCSV.class);

        MappingIterator<MetroStationsCSV> iterator =
                mapper
                .readerFor(MetroStationsCSV.class)
                .with(schema)
                .readValues(myReader);

        List<MetroStationsCSV> list = iterator.readAll();
        return list;
    }

}
