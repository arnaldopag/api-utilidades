package com.example.utilidades.bet_control.bet;

import com.example.utilidades.bet_control.enums.BetElement;
import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetClassification;
import com.example.utilidades.bet_control.enums.Sports;
import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.player.Player;
import com.example.utilidades.bet_control.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column(name = "odd", nullable = false,precision = 2)
    private Long odd;

    @Column(name = "bet_amount", nullable = false,precision = 2)
    private BigDecimal betAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private BetStatus status;

    @Column(name = "bet_date_time_creation",nullable = false)
    private LocalDateTime betDateTimeCreation;

    @Column(name = "bet_dead_line")
    private LocalDateTime betDeadLine;

    @Enumerated(EnumType.STRING)
    @Column(name = "bet_type", nullable = false)
    private BetClassification betClassification;

    @Enumerated(EnumType.STRING)
    @Column(name = "bet_element",nullable = false)
    private BetElement betElement;

    @Enumerated(EnumType.STRING)
    @Column(name = "sports",nullable = false)
    private Sports sports;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;




    public Bet(BetRequestDTO data) {
        this.odd = data.odd();
        this.betAmount = data.betAmount();
        this.status = BetStatus.PENDING;
        this.betDeadLine = data.betDeadLine();
        this.betClassification = data.betClassification();
        this.team = data.team();
        this.player = data.player();
        this.sports = data.sports();
        this.betDateTimeCreation = LocalDateTime.now();
    }

}
