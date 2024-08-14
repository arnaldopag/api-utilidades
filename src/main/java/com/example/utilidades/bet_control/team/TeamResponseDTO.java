package com.example.utilidades.bet_control.team;

import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.league.LeagueResponseDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record TeamResponseDTO(Long id,
                              String name,
                              String coutry,
                              String stadium,
                              String coach,
                              @JsonManagedReference
                              Set<LeagueResponseDTO> leagues,
                              Date fundationDate
) {
    public TeamResponseDTO(Team team) {
        this(
                team.getId(),
                team.getName(),
                team.getCoach(),
                team.getCountry(),
                team.getStadium(),
                mapLeagueToDTO(team.getLeagues()),
                team.getFundationDate()
        );
    }

    public static TeamResponseDTO TeamResponseDTOWithoutLeague(Team team) {
        return new TeamResponseDTO(
                team.getId(),
                team.getName(),
                team.getCoach(),
                team.getCountry(),
                team.getStadium(),
                Collections.emptySet(),
                team.getFundationDate()
        );
    }

    private static Set<LeagueResponseDTO> mapLeagueToDTO(Set<League> leagues) {
        if (leagues == null) {
            return  Collections.emptySet();
        }
        return leagues.stream()
                .map(LeagueResponseDTO::leagueWithoutTeams).collect(Collectors.toSet());
    }
}

