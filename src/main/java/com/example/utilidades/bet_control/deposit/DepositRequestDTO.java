package com.example.utilidades.bet_control.deposit;

import com.example.utilidades.bet_control.betting_house.BettingHouse;

import java.math.BigDecimal;

public record DepositRequestDTO(
         BigDecimal amount,
        BettingHouse bettingHouse
) {
}
