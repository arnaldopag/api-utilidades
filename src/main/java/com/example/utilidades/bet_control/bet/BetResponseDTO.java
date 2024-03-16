package com.example.utilidades.bet_control.bet;

import com.example.utilidades.bet_control.enums.BetElement;
import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetClassification;
import com.example.utilidades.bet_control.enums.Sports;
import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.player.Player;
import com.example.utilidades.bet_control.team.Team;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BetResponseDTO(
        Long id,
        Long odd,
        BigDecimal betAmount,
        BetStatus status,
        LocalDateTime betDateTimeCreation,
        LocalDateTime betDeadLine,
        BetClassification betClassification,
        BetElement betElement,
        League league,
        Team team,
        Player player,

        Sports sports
) {

    public BetResponseDTO(Bet bet){
        this(   bet.getId(),
                bet.getOdd(),
                bet.getBetAmount(),
                bet.getStatus(),
                bet.getBetDateTimeCreation(),
                bet.getBetDeadLine(),
                bet.getBetClassification(),
                bet.getBetElement(),
                bet.getLeague(),
                bet.getTeam(),
                bet.getPlayer(),
                bet.getSports()
        );
    }

}
