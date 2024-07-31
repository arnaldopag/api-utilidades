package com.example.utilidades.bet_control.service;

import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.league.LeagueRepository;
import com.example.utilidades.bet_control.league.LeagueRequestDTO;
import com.example.utilidades.bet_control.seasons.Season;
import com.example.utilidades.bet_control.seasons.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private SeasonRepository seasonRepository;


    public ResponseEntity<League> saveLeague(LeagueRequestDTO data){
        League league = new League(data);
        List<Season> seasons = seasonRepository.findAll();
        league.getSeasons().addAll(seasons);

        leagueRepository.save(league);

        return ResponseEntity.status(HttpStatus.CREATED).body(league);
    }
}
