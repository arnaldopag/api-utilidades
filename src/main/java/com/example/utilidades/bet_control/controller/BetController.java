package com.example.utilidades.bet_control.controller;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRepository;
import com.example.utilidades.bet_control.bet.BetRequestDTO;
import com.example.utilidades.bet_control.bet.BetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetRepository repository;



    @PostMapping("/save")
    public ResponseEntity<Bet> saveBet(@RequestBody BetRequestDTO data){
        Bet bet = new Bet(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(bet));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BetResponseDTO>> getAll(){
        List<BetResponseDTO> betList = repository.findAll().stream().map(BetResponseDTO::new).toList();
        return new ResponseEntity<>(betList, HttpStatus.OK);
    }
}
