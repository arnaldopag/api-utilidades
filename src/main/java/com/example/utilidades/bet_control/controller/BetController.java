package com.example.utilidades.bet_control.controller;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRepository;
import com.example.utilidades.bet_control.bet.BetRequestDTO;
import com.example.utilidades.bet_control.bet.BetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetRepository betRepository;



    @PostMapping("/save")
    public ResponseEntity<Bet> saveBet(@RequestBody BetRequestDTO data){
        Bet bet = new Bet(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(betRepository.save(bet));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BetResponseDTO>> getAll(){
        List<BetResponseDTO> betList = betRepository.findAll().stream().map(BetResponseDTO::new).toList();
        return new ResponseEntity<>(betList, HttpStatus.OK);
    }


    @PutMapping("/status")
    public ResponseEntity<Bet> changeBetStatus(@Validated @RequestBody Bet updatedBet) {
        try {
            if (updatedBet.getId() == null) {
                return ResponseEntity.badRequest().build();
            }
            Optional<Bet> optionalBet = betRepository.findById(updatedBet.getId());
            if (!optionalBet.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Bet existingBet = optionalBet.get();
            existingBet.setStatus(updatedBet.getStatus());
            betRepository.save(existingBet);

            return ResponseEntity.ok(existingBet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
