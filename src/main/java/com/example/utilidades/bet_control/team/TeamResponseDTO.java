package com.example.utilidades.bet_control.team;

import com.example.utilidades.bet_control.competitions.Competitions;
import com.example.utilidades.bet_control.competitions.CompetitionsResponseDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
                              Set<CompetitionsResponseDTO> competitions,
                              Date fundationDate){
    public TeamResponseDTO(Team team){
        this(
                team.getId(),
                team.getName(),
                team.getCoach(),
                team.getCountry(),
                team.getStadium(),
                mapCompetitionsToDTO(team.getCompetitions()),
                team.getFundationDate()
        );
    }

    public static TeamResponseDTO TeamResponseDTOWithNoCompetitions(Team team){
        return new TeamResponseDTO(
            team.getId(),
            team.getName(),
            team.getCoach(),
            team.getCountry(),
            team.getStadium(),
            new HashSet<>(),
            team.getFundationDate()
        );
    }
    private static Set<CompetitionsResponseDTO> mapCompetitionsToDTO(Set<Competitions> competitions) {
        if (competitions == null) {
            return null;
        }
        return competitions.stream()
                .map(CompetitionsResponseDTO::competitionsWithNoTeams).collect(Collectors.toSet());
    }
}

