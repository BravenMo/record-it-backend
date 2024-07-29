package com.example.backendWebAppTest.Services;

import com.example.backendWebAppTest.model.ShowData;
import com.example.backendWebAppTest.repository.ShowDataRepository;
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
public class ShowCSVService {

    @Autowired
    private ShowDataRepository showDataRepository;

    public void readCSVAndSave() throws IOException {
        String filepath = "D:\\WebApplicationProject\\Data\\archive\\netflix_titles_nov_2019.csv";
        Reader reader=new FileReader(filepath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
        List<ShowData> entities = new ArrayList<>();

        for(CSVRecord csvRecord:csvParser){
            ShowData entity = new ShowData();
            entity.setTitle(csvRecord.get("title"));
            entity.setDirector(csvRecord.get("director"));
            entity.setCountry(csvRecord.get("country"));
            entity.setDate(csvRecord.get("date_added"));
            entity.setDuration(csvRecord.get("duration"));
            entity.setDescription(csvRecord.get("description"));
            entity.setType(csvRecord.get("type"));
            entities.add(entity);
        }
        showDataRepository.saveAll(entities);
    }
}
