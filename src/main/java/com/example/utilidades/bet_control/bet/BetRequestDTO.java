package com.example.utilidades.bet_control.bet;

import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetType;
import com.example.utilidades.bet_control.player.Player;
import com.example.utilidades.bet_control.team.Team;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record BetRequestDTO(
        Long odd,
        BigDecimal betAmount,
        BetStatus status,
        String betTeam,
        LocalDateTime betDeadLine,
        BetType betType,
        List<Team> teams,
        List<Player> players
    ) {

}
