package com.example.utilidades.bet_control.controller;

import com.example.utilidades.bet_control.competitions.Competitions;
import com.example.utilidades.bet_control.competitions.CompetitionsRepository;
import com.example.utilidades.bet_control.competitions.CompetitionsRequestDTO;
import com.example.utilidades.bet_control.competitions.CompetitionsResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionsRepository repository;


    @PostMapping("/save")
    public ResponseEntity<CompetitionsRequestDTO> save(@RequestBody CompetitionsRequestDTO data){
        Competitions competitions = new Competitions(data);
        repository.save(competitions);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CompetitionsResponseDTO>> getAll(){
        List<CompetitionsResponseDTO> competitions = repository.findAll().stream()
                                                        .map(CompetitionsResponseDTO::competitionsWithNoTeams).toList();
        return ResponseEntity.status(HttpStatus.OK).body(competitions);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<CompetitionsResponseDTO> getById(@PathVariable Long id){
        Optional<Competitions> optionalCompetitions = repository.findById(id);

        return optionalCompetitions.map( competitions -> ResponseEntity.ok(new CompetitionsResponseDTO(competitions)))
                .orElseGet(() -> ResponseEntity.notFound().build());


    }
}
