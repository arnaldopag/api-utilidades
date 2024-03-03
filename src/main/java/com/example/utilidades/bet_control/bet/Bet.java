package com.example.utilidades.bet_control.bet;

import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetType;
import com.example.utilidades.bet_control.player.Player;
import com.example.utilidades.bet_control.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bet")
@Table(name = "bet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "odd", nullable = false)
    private Long odd;

    @Column(name = "bet_amount", nullable = false)
    private BigDecimal betAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BetStatus status;

    @Column(name = "bet_team",nullable = false)
    private String betTeam;

    @Column(name = "bet_date_time")
    private LocalDateTime betDateTime;

    @Column(name = "bet_dead_line")
    private LocalDateTime betDeadLine;

    @Enumerated(EnumType.STRING)
    @Column(name = "bet_type", nullable = false)
    private BetType betType;

    private List<Team> teams = new ArrayList<>();

    private List<Player> players = new ArrayList<>();


    public Bet(BetRequestDTO data) {
        this.odd = data.odd();
        this.betAmount = data.betAmount();
        this.status = data.status();
        this.betTeam = data.betTeam();
        this.betDeadLine = data.betDeadLine();
        this.betType = data.betType();
    }

    @PrePersist
    public void prePersist(){
        this.betDateTime = LocalDateTime.now();
    }

}
