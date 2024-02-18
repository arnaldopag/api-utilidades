package com.example.utilidades.bet_control.team;

import com.example.utilidades.bet_control.competitions.Competitions;
import com.example.utilidades.bet_control.player.Player;

import java.util.Date;
import java.util.List;
import java.util.Set;

public record TeamRequestDTO(
        String name,
        String country,
        String stadium,
        String coach,
        Set<Competitions> competitions,
        Date fundationDate,
        List<Player> players
) {
}
