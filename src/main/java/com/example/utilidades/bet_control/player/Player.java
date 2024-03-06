package com.example.utilidades.bet_control.player;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "player")
@Table(name = "player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Team team;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "jersey_number")
    private Integer jerseyNumber;

    @Column(precision = 2)
    private Long weight;

    @Column(precision = 1)
    private Long height;

    @Column
    private String photo;

    @Column
    private  Long idApi;

    @ManyToMany
    @JoinTable(
            name = "bet_player",
            joinColumns = @JoinColumn(name = "bet_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Bet> betSet = new HashSet<>();

}
