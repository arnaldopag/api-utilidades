package com.example.utilidades.bet_control.deposit;

import com.example.utilidades.bet_control.betting_house.BettingHouse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, precision = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime dateTimeCreation;

    @ManyToOne
    @JoinColumn(name = "betting_house_id")
    private BettingHouse bettingHouse;

    public Deposit(DepositRequestDTO data){
        this.amount = data.amount();
        this.bettingHouse = data.bettingHouse();
        this.dateTimeCreation = LocalDateTime.now();
    }
}
