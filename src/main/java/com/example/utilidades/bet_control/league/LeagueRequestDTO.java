package com.example.utilidades.bet_control.league;

import com.example.utilidades.bet_control.team.Team;

import java.util.Date;
import java.util.Set;

public record LeagueRequestDTO(
        String name,
        String country,
        String logo,
        Date startDate,
        Date endDate,
        Integer season,

        String abbreviation,
        Long idApi,

        Set<Team> teams
) {
}
