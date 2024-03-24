package com.example.utilidades.bet_control.betting_house;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "betting_house")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BettingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "house_bank_roll",nullable = false, precision = 2)
    private BigDecimal houseBankRoll;

}



