package com.example.backendWebAppTest.Services;
import com.example.backendWebAppTest.repository.NovelDataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import com.example.backendWebAppTest.model.NovelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class NovelCSVService {

    @Autowired
    private NovelDataRepository novelDataRepository;

    public void readCSVAndSave() throws IOException{
        String filepath = "D:\\WebApplicationProject\\Data\\results_novels.csv";
        Reader reader=new FileReader(filepath);
        CSVParser csvParser = new CSVParser(reader,CSVFormat.DEFAULT.withHeader());
        List<NovelData> entities = new ArrayList<>();

        for(CSVRecord csvRecord:csvParser){
            NovelData entity = new NovelData();
            entity.setDescription(csvRecord.get("description"));
            entity.setPrice(csvRecord.get("price"));
            entity.setRating(csvRecord.get("rating"));
            entity.setReview_count(csvRecord.get("review_count"));
            entity.setAuthor(csvRecord.get("author"));
            entity.setBinding(csvRecord.get("binding"));
            entity.setBestseller(csvRecord.get("bestseller"));
            entities.add(entity);
        }
        novelDataRepository.saveAll(entities);
    }
}
