package com.example.backendWebAppTest.controller;


import com.example.backendWebAppTest.Services.GameCSVService;
import com.example.backendWebAppTest.Services.NovelCSVService;
import com.example.backendWebAppTest.Services.ShowCSVService;
import com.example.backendWebAppTest.model.GameData;
import com.example.backendWebAppTest.model.NovelData;
import com.example.backendWebAppTest.model.ShowData;
import com.example.backendWebAppTest.repository.GameDataRepository;
import com.example.backendWebAppTest.repository.NovelDataRepository;
import com.example.backendWebAppTest.repository.ShowDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    @Autowired
    private NovelDataRepository novelDataRepository;

    @Autowired
    private ShowDataRepository showDataRepository;

    @Autowired
    private GameDataRepository gameDataRepository;

    @Autowired
    private NovelCSVService novelCsvService;

    @Autowired
    private ShowCSVService showCSVService;

    @Autowired
    private GameCSVService gameCSVService;

    @GetMapping("/novels")
    private List<NovelData> getAllNovels() throws IOException {
        novelCsvService.readCSVAndSave();
        return novelDataRepository.findAll();
    }

    @GetMapping("/showsAndMovies")
    private List<ShowData> getAllShowsAndMovies() throws IOException{
        showCSVService.readCSVAndSave();
        return showDataRepository.findAll();
    }

    @GetMapping("/games")
    private List<GameData> getAllGames() throws IOException{
        gameCSVService.readCSVAndSave();
        return gameDataRepository.findAll();
    }

}
