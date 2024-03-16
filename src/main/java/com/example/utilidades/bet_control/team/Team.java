package com.example.utilidades.bet_control.team;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "stadium", nullable = false)
    private String stadium;

    @Column(name = "coach", nullable = false)
    private String coach;

    @Temporal(TemporalType.DATE)
    @Column(name = "fundation_date")
    private Date fundationDate;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> players;

    @ManyToMany
    @JoinTable(
            name = "league_teams",
            joinColumns = @JoinColumn(name = "league_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<League> leagues = new HashSet<>();


    public Team(TeamRequestDTO data) {
        this.name = data.name();
        this.coach = data.coach();
        this.country = data.country();
        this.fundationDate = data.fundationDate();
        this.stadium = data.stadium();
        this.players = data.players();
        this.leagues = data.leagues();
    }
}
