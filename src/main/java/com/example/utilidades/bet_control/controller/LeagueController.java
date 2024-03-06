package com.example.utilidades.bet_control.controller;

import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.league.LeagueRepository;
import com.example.utilidades.bet_control.league.LeagueRequestDTO;
import com.example.utilidades.bet_control.league.LeagueResponseDTO;
import com.example.utilidades.bet_control.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/league")
public class LeagueController {
    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueService leagueService;

    @PostMapping("/save")
    public ResponseEntity<League> saveLeague(@RequestBody LeagueRequestDTO data){
        return leagueService.saveLeague(data);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LeagueResponseDTO>> getAll(){
        List<LeagueResponseDTO> leagues = leagueRepository.findAll().stream().map(
                                            LeagueResponseDTO::leagueWithoutTeams).toList();

        return new ResponseEntity<>(leagues,HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<LeagueResponseDTO> findById(@PathVariable Long id){
        Optional<League> optionalLeague = leagueRepository.findById(id);
        return optionalLeague.map( league -> ResponseEntity.ok(new LeagueResponseDTO(league)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
