package com.example.utilidades.bet_control.bet;


import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;

    private static final QBet qBet = QBet.bet;

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

    public List<Bet> getAllByTeam(Long teamID){
        BooleanExpression booleanExpression = qBet.team.id.eq(teamID);
        return (List<Bet>) betRepository.findAll(booleanExpression);
    }
}
