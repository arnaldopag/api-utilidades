package com.example.utilidades.bet_control.service;

import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.league.LeagueRepository;
import com.example.utilidades.bet_control.team.Team;
import com.example.utilidades.bet_control.team.TeamRepository;
import com.example.utilidades.bet_control.team.TeamRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class TeamService {


    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;


    public ResponseEntity<TeamRequestDTO> saveTeamWithLeague(@RequestBody TeamRequestDTO data) {
        try {
            Long leagueId = data.leagues().iterator().next().getId();
            Optional<League> optionalLeague = leagueRepository.findById(leagueId);

            optionalLeague.ifPresent( league -> {
                Team team = new Team(data);
                Team savedTeam = teamRepository.save(team);

                league.getTeams().add(savedTeam);
                leagueRepository.save(league);
            });

            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
