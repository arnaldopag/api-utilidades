package com.example.utilidades.bet_control.withdrawal;

import com.example.utilidades.bet_control.betting_house.BettingHouse;

import java.math.BigDecimal;

public record WithdrawalRequestDTO(
        BigDecimal amount,
        BettingHouse bettingHouse

) {
}
