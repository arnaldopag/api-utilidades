package com.example.utilidades.bet_control.competitions;

import com.example.utilidades.bet_control.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "competitions")
@Table(name = "competitions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Competitions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "competition_teams",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> teams = new HashSet<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "season")
    private Integer season;

    @Column(name = "abbreviation")
    private String abbreviation;

    public Competitions(CompetitionsRequestDTO data) {
        this.name = data.name();
        this.teams = data.teams();
        this.endDate = data.endDate();
        this.season = data.season();
        this.startDate = data.startDate();
    }
}
