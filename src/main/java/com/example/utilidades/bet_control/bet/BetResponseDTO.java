package com.example.utilidades.bet_control.bet;

import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BetResponseDTO(
        Long id,
        Long odd,
        BigDecimal betAmount,
        BetStatus status,
        String betTeam,
        LocalDateTime betDateTime,
        LocalDateTime betDeadLine,
        BetType betType
) {

    public BetResponseDTO(Bet bet){
        this(   bet.getId(),
                bet.getOdd(),
                bet.getBetAmount(),
                bet.getStatus(),
                bet.getBetTeam(),
                bet.getBetDateTime(),
                bet.getBetDeadLine(),
                bet.getBetType()
        );
    }

}
