package com.example.utilidades.bet_control.service;

import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.league.LeagueRepository;
import com.example.utilidades.bet_control.team.Team;
import com.example.utilidades.bet_control.team.TeamRepository;
import com.example.utilidades.bet_control.team.TeamRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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


    public ResponseEntity<?> saveTeamWithLeague(@RequestBody TeamRequestDTO data) {
        try {
            Long leagueId = data.leagues().iterator().next().getId();
            Optional<League> optionalLeague = leagueRepository.findById(leagueId);

            if (!optionalLeague.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("League not found with ID: " + leagueId);
            }

            optionalLeague.ifPresent( league -> {
                Team team = new Team(data);
                Team savedTeam = teamRepository.save(team);

                league.getTeams().add(savedTeam);
                leagueRepository.save(league);
            });
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        }catch (DataAccessException e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "An error ocourred while saving the team " + e.getMessage()
            );
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "An unexpected error occurred: " + e.getMessage()
            );
        }
    }


}
