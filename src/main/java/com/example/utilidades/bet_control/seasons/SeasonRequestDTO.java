package com.example.utilidades.bet_control.seasons;

import java.util.Date;

public record SeasonRequestDTO(
        Date startDate,
        Date enDate,
        Boolean current,
        Integer year
) {
}
