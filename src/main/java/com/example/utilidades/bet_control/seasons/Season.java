package com.example.utilidades.bet_control.seasons;

import com.example.utilidades.bet_control.league.League;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Season {

    @Id
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column
    private Boolean current;

    @Column
    private Integer year;
}
