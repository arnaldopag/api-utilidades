package com.example.utilidades.bet_control.service;


import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;

    public ResponseEntity<Bet> changeStatus(Bet updatedBet){
        try {
            Optional<Bet> optionalBet = betRepository.findById(updatedBet.getId());
            if (optionalBet.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Bet existingBet = optionalBet.get();
            existingBet.setStatus(updatedBet.getStatus());

            return ResponseEntity.ok(betRepository.save(existingBet));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
