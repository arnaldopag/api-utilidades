package com.example.utilidades.bet_control.team;

import com.example.utilidades.bet_control.competitions.Competitions;
import com.example.utilidades.bet_control.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(mappedBy = "teams")
    private Set<Competitions> competitions = new HashSet<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;


    public Team(TeamRequestDTO data) {
        this.name = data.name();
        this.coach = data.coach();
        this.country = data.country();
        this.stadium = data.stadium();
        this.competitions = data.competitions();
        this.fundationDate = data.fundationDate();
        this.players = data.players();
    }
}
