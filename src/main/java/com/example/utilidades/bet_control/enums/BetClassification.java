package com.example.utilidades.bet_control.enums;

public enum BetClassification {

    WINNER("Winner", "W"),
    HANDICAP("Handicap","H"),
    OVER("Over","O"),
    UNDER("Under", "U");

    private String value;
    private String description;

    BetClassification(String description, String value){
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
