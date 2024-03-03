package com.example.utilidades.bet_control.controller;

import com.example.utilidades.bet_control.service.TeamService;
import com.example.utilidades.bet_control.team.Team;
import com.example.utilidades.bet_control.team.TeamRepository;
import com.example.utilidades.bet_control.team.TeamRequestDTO;
import com.example.utilidades.bet_control.team.TeamResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<?>saveTeam(@RequestBody TeamRequestDTO data){
        if(data.leagues() == null){
            String errorMessage = "Unable to save team: At least one competition must be specified.";
            return ResponseEntity.badRequest().body(errorMessage);
        }

        return teamService.saveTeamWithLeague(data);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<TeamResponseDTO>> getAll(){
        List<TeamResponseDTO> teamList = teamRepository.findAll().stream()
                                                  .map(TeamResponseDTO::TeamResponseDTOWithoutLeague).toList();
        return new ResponseEntity<>(teamList,HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<TeamResponseDTO> getById(@PathVariable Long id){

        Optional<Team> optionalTeam  = teamRepository.findById(id);

        return optionalTeam.map( team -> ResponseEntity.ok(new TeamResponseDTO(team)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
