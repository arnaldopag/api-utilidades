package com.example.utilidades.bet_control.enums;

public enum BetElement {

    PONTS("Points","P"),
    SCORE("Score","S"),
    MAP("Map","M"),
    DRAGON("Dragon","D"),
    GOL("Gol","G"),
    ASSISTENCE("Assistence", "A"),
    KILL("Kill","K");

    private String value;
    private String description;

    BetElement(String description, String value){
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
