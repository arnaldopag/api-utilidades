package com.example.utilidades.bet_control.player;

import com.example.utilidades.bet_control.team.TeamResponseDTO;

import java.util.Date;

public record PlayerRequestDTO(
        String name,
        TeamResponseDTO teamResponseDTO,
        Date birthDate,
        Integer jerseyNumber,
        Long weight,
        Long height,
        String photo,
        Long idApi
) {
}
