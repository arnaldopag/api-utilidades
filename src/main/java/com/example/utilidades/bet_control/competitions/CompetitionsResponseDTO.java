package com.example.utilidades.bet_control.competitions;

import com.example.utilidades.bet_control.team.Team;
import com.example.utilidades.bet_control.team.TeamResponseDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record CompetitionsResponseDTO(Long id,
                                      String name,
                                      @JsonManagedReference
                                      Set<TeamResponseDTO> teams,
                                      Date endDate,
                                      Date startDate,
                                      Integer season,
                                      String abbreviation) {
    public CompetitionsResponseDTO(Competitions competitions){
        this(
                competitions.getId(),
                competitions.getName(),
                mapTeamsToDTO(competitions.getTeams()),
                competitions.getEndDate(),
                competitions.getStartDate(),
                competitions.getSeason(),
                competitions.getAbbreviation()
        );
    }

    public static CompetitionsResponseDTO competitionsWithNoTeams(Competitions competitions){
        return new CompetitionsResponseDTO(
                competitions.getId(),
                competitions.getName(),
                new HashSet<>(),
                competitions.getEndDate(),
                competitions.getStartDate(),
                competitions.getSeason(),
                competitions.getAbbreviation()
        );
    }

    private static Set<TeamResponseDTO> mapTeamsToDTO(Set<Team> teams) {
        if (teams == null) {
            return new HashSet<>();
        }
        return teams.stream()
                .map(TeamResponseDTO::TeamResponseDTOWithNoCompetitions).collect(Collectors.toSet());
    }
}
