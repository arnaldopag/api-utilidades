package com.example.utilidades.bet_control.seasons;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        List<Season>seasons =new ArrayList<>();
        try{
            seasons.add(new Season(1L,dateFormat.parse( "2021-08-13"),dateFormat.parse("2022-05-22"),false,2021 ));
            seasons.add(new Season(2L,dateFormat.parse("2022-08-12"),dateFormat.parse("2023-06-04"),false,2022 ));
            seasons.add(new Season(3L,dateFormat.parse("2023-08-11"),dateFormat.parse( "2024-05-26"),true,2023 ));
            seasonRepository.saveAll(seasons);
        }catch (ParseException e){
         e.printStackTrace();
        }

    }
}
