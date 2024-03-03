package com.example.utilidades.bet_control.enums;

public enum BetType {

    WINNER("Winner team", "W"),
    HANDCAP("Handcap","H"),
    PONTS("Points","P"),
    SCORE("Score","S"),
    GOL("Gol","G"),
    ASSISTENCE("Assistence", "A"),
    KILL("Kill","K");
    private String value;
    private String description;

    BetType(String description, String value){
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
