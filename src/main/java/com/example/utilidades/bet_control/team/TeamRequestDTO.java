package com.example.utilidades.bet_control.team;

import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.player.Player;

import java.util.Date;
import java.util.Set;

public record TeamRequestDTO(
        String name,
        String country,
        String stadium,
        String coach,
        Date fundationDate,
        Set<Player> players,
        Set<League> leagues
) {
}
