package com.example.utilidades.bet_control.withdrawal;

import com.example.utilidades.bet_control.betting_house.BettingHouse;
import com.example.utilidades.bet_control.deposit.DepositRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "withdrawal")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Withdrawal {
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

    public Withdrawal(WithdrawalRequestDTO data){
        this.amount = data.amount();
        this.bettingHouse = data.bettingHouse();
        this.dateTimeCreation = LocalDateTime.now();
    }

}
