package com.example.utilidades.bet_control.controller;

import com.example.utilidades.bet_control.seasons.Season;
import com.example.utilidades.bet_control.seasons.SeasonRepository;
import com.example.utilidades.bet_control.seasons.SeasonRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/season")
public class SeasonController {



    private SeasonRepository repository;



    @PostMapping("/save")
    public ResponseEntity<Season> save(@RequestBody SeasonRequestDTO data){
        Season season = new Season(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(season));
    }
}
