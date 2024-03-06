package com.example.utilidades.bet_control.service;

import com.example.utilidades.bet_control.seasons.Season;
import com.example.utilidades.bet_control.seasons.SeasonRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class SeasonService {


    @Autowired
    private SeasonRepository seasonRepository;
    @PostConstruct
    public void checkAnPopulateSeasons(){
        List<Season> seasons = seasonRepository.findAll();
        if(seasons.isEmpty()){
            populateSeasons();
        }
    }


    private void populateSeasons(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Season season1 = new Season(1L,dateFormat.parse("2010-08-28"),dateFormat.parse("2011-05-21"),false,2010 );
            Season season2 = new Season(2L,dateFormat.parse( "2011-08-27"),dateFormat.parse( "2012-05-13"),false,2011 );
            Season season3 = new Season(3L,dateFormat.parse( "2012-08-18"),dateFormat.parse( "2013-06-01"),false,2012 );
            Season season4 = new Season(4L,dateFormat.parse( "2013-08-17"),dateFormat.parse( "2014-05-18"),false,2013 );
            Season season5 = new Season(5L,dateFormat.parse("2014-08-23"),dateFormat.parse( "2015-05-23"),false,2014 );
            Season season6 = new Season(6L,dateFormat.parse("2015-08-21"),dateFormat.parse("2016-05-15"),false,2015 );
            Season season7 = new Season(7L,dateFormat.parse("2016-08-19"),dateFormat.parse("2017-05-21"),false,2016 );
            Season season8 = new Season(8L,dateFormat.parse("2017-08-18"),dateFormat.parse("2018-05-20"),false,2017 );
            Season season9 = new Season(9L,dateFormat.parse( "2018-08-17"),dateFormat.parse( "2019-05-19"),false,2018 );
            Season season10 = new Season(10L,dateFormat.parse("2019-08-16"),dateFormat.parse("2020-07-19"),false,2019 );
            Season season11 = new Season(11L,dateFormat.parse( "2020-09-12"),dateFormat.parse("2021-05-23"),false,2020 );
            Season season12 = new Season(12L,dateFormat.parse( "2021-08-13"),dateFormat.parse("2022-05-22"),false,2021 );
            Season season13 = new Season(13L,dateFormat.parse("2022-08-12"),dateFormat.parse("2023-06-04"),false,2022 );
            Season season14 = new Season(14L,dateFormat.parse("2023-08-11"),dateFormat.parse( "2024-05-26"),true,2023 );
            seasonRepository.saveAll(List.of(season1,season2,season3,season4,
                    season5,season6,season7,season8,season9,season10,season11,
                    season12,season13,season14));
        }catch (ParseException e){
         e.printStackTrace();
        }

    }
}
