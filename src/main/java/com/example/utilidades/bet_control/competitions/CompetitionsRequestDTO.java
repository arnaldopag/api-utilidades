package com.example.utilidades.bet_control.competitions;

import com.example.utilidades.bet_control.team.Team;

import java.util.Date;
import java.util.Set;

public record CompetitionsRequestDTO(String name, Set<Team> teams, Date endDate, Date startDate, Integer season, String abbreviation) {
}
