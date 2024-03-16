package com.example.utilidades.bet_control.enums;

public enum Sports {

    FOOTBALL("Football","F"),
    LOL("League of Legends","L"),
    BASKETBALL("Basktball","B"),
    CS("Counter-Strike 2","C"),
    TENNIS("Tennis","T");


    private String value;
    private String description;

    Sports(String description, String value){
        this.description =  description;
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public String getDescription() {
        return description;
    }
}
