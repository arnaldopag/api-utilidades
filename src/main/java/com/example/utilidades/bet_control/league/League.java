package com.example.utilidades.bet_control.league;

import com.example.utilidades.bet_control.seasons.Season;
import com.example.utilidades.bet_control.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String country;

    @Column
    private String logo;

    @ManyToMany()
    @JoinTable(
            name = "leagues_seasons",
            joinColumns = @JoinColumn(name = "league_id"),
            inverseJoinColumns = @JoinColumn(name = "season_id")
    )
    private Set<Season> seasons = new HashSet<>();

    @Column
    private String abbreviation;

    @Column
    private Long idApi;


    @ManyToMany(mappedBy = "leagues")
    private Set<Team> teams = new HashSet<>();

    public League(LeagueRequestDTO data){
        this.name = data.name();
        this.country = data.country();
        this.logo = data.logo();
        this.abbreviation = data.abbreviation();
        this.idApi = data.idApi();
    };

}
