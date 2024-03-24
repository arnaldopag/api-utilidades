package com.example.utilidades.bet_control.bet;

import com.example.utilidades.bet_control.betting_house.BettingHouse;
import com.example.utilidades.bet_control.enums.BetElement;
import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetClassification;
import com.example.utilidades.bet_control.enums.Sports;
import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.player.Player;
import com.example.utilidades.bet_control.team.Team;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BetRequestDTO(
        BigDecimal odd,
        BigDecimal betAmount,
        BetStatus status,
        LocalDateTime betDeadLine,
        BetClassification betClassification,
        BetElement betElement,
        League league,
        Team team,
        Player player,
        Sports sports,
        BettingHouse bettingHouse
    ) {

}
