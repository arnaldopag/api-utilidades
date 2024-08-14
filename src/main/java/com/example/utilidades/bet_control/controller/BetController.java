package com.example.utilidades.bet_control.controller;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRepository;
import com.example.utilidades.bet_control.bet.BetRequestDTO;
import com.example.utilidades.bet_control.bet.BetResponseDTO;
import com.example.utilidades.bet_control.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private BetService betService;


    @PostMapping("/save")
    public ResponseEntity<Bet> saveBet(@RequestBody BetRequestDTO data){
        Bet bet = new Bet(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(betRepository.save(bet));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BetResponseDTO>> getAll(){

        List<BetResponseDTO> betList = betRepository.findAll()
                                        .stream().map(BetResponseDTO::new).toList();

        return ResponseEntity.ok(betList.isEmpty() ? Collections.emptyList() : betList);

    }


    @PutMapping("/status")
    public ResponseEntity<Bet> changeBetStatus(@Validated @RequestBody Bet updatedBet) {
        return betService.changeStatus(updatedBet);
    }

    @GetMapping("/getAllByTeam/{teamID}")
    public ResponseEntity<List<Bet>> getBetByTeamID(@PathVariable Long teamID){
        List<Bet> betList = betService.getAllByTeam(teamID);
        return ResponseEntity.ok( betList.isEmpty() ? Collections.emptyList()  :betList);
    }
}
