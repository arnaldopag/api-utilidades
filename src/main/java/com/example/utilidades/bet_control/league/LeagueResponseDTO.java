package com.example.utilidades.bet_control.league;

import com.example.utilidades.bet_control.team.Team;
import com.example.utilidades.bet_control.team.TeamResponseDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record LeagueResponseDTO(
        Long id,
        String name,
        String country,
        String logo,
        Date startDate,
        Date endDate,
        Integer season,

        String abbreviation,
        Long idApi,
        @JsonManagedReference
        Set<TeamResponseDTO> teams
) {

    public LeagueResponseDTO(League league){

        this(
                league.getId(),
                league.getName(),
                league.getCountry(),
                league.getLogo(),
                league.getStartDate(),
                league.getEndDate(),
                league.getSeason(),
                league.getAbbreviation(),
                league.getIdApi(),
                mapTeamsToDTO(league.getTeams())
        );
    }

    public static LeagueResponseDTO leagueWithoutTeams(League league){
        return new LeagueResponseDTO(
                league.getId(),
                league.getName(),
                league.getCountry(),
                league.getLogo(),
                league.getStartDate(),
                league.getEndDate(),
                league.getSeason(),
                league.getAbbreviation(),
                league.getIdApi(),
                new HashSet<>()
        );
    }

    private static Set<TeamResponseDTO> mapTeamsToDTO(Set<Team> teams) {
        if (teams == null) {
            return new HashSet<>();
        }
        return teams.stream()
                .map(TeamResponseDTO::TeamResponseDTOWithoutLeague).collect(Collectors.toSet());
    }


}
