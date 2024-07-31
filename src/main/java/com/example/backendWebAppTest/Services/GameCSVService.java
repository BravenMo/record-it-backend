package com.example.backendWebAppTest.Services;

import com.example.backendWebAppTest.model.GameData;
import com.example.backendWebAppTest.model.ShowData;
import com.example.backendWebAppTest.repository.GameDataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameCSVService {

    @Autowired
    private GameDataRepository gameDataRepository;

    public void readCSVAndSave() throws IOException {
        String filepath = "D:\\WebApplicationProject\\Data\\vgsales\\vgsales.csv";
        Reader reader=new FileReader(filepath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
        List<GameData> entities = new ArrayList<>();

        for(CSVRecord csvRecord:csvParser){
            GameData entity = new GameData();
            entity.setName(csvRecord.get("Name"));
            entity.setPlatform(csvRecord.get("Platform"));
            entity.setGenre(csvRecord.get("Genre"));
            entity.setYear(csvRecord.get("Year"));
            entity.setPublisher(csvRecord.get("Publisher"));
            entities.add(entity);
        }
        gameDataRepository.saveAll(entities);
    }
}
