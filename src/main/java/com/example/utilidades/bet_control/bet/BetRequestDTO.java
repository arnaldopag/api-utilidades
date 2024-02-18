package com.example.utilidades.bet_control.bet;

import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BetRequestDTO(
        Long odd,
        BigDecimal betAmount,
        BetStatus status,
        String betTeam,
        LocalDateTime betDeadLine,
        BetType betType
    ) {

}
