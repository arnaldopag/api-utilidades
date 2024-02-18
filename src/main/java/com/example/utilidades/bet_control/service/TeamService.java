package com.example.utilidades.bet_control.service;

import com.example.utilidades.bet_control.competitions.Competitions;
import com.example.utilidades.bet_control.competitions.CompetitionsRepository;
import com.example.utilidades.bet_control.competitions.CompetitionsResponseDTO;
import com.example.utilidades.bet_control.team.Team;
import com.example.utilidades.bet_control.team.TeamRepository;
import com.example.utilidades.bet_control.team.TeamRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Optional;

@Service
public class TeamService {


    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CompetitionsRepository competitionsRepository;



    public ResponseEntity<TeamRequestDTO> saveTeamCompetition(@RequestBody TeamRequestDTO data){

        Long competitionId = data.competitions()
                .iterator()
                .next().getId();
        System.out.println(competitionId);
        Optional<Competitions> competitions = competitionsRepository.findById(competitionId);
        if(competitions.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Team team = new Team(data);
        Team saved = teamRepository.save(team);
        System.out.println(saved);
        Competitions comp = competitions.get();
        comp.getTeams().add(saved);
        competitionsRepository.save(comp);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

}
