package com.example.utilidades.bet_control.player;

import com.example.utilidades.bet_control.team.TeamResponseDTO;

import java.util.Date;

public record PlayerResponseDTO(
        Long id,
        String name,
        TeamResponseDTO teamResponseDTO,
        Date birthDate,
        Integer jerseyNumber,
        Long weight,
        Long height,
        String photo,
        Long idApi
) {


    public PlayerResponseDTO(Player player){
        this(
                player.getId(),
                player.getName(),
                new TeamResponseDTO(player.getTeam()),
                player.getBirthDate(),
                player.getJerseyNumber(),
                player.getWeight(),
                player.getHeight(),
                player.getPhoto(),
                player.getIdApi()
        );
    }

}
