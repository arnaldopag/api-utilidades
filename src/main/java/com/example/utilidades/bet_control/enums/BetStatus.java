package com.example.utilidades.bet_control.enums;

public enum BetStatus {

    WiN("Win","W"),
    LOSS("Loss","L"),
    PENDING("Pending","P");

    private String value;
    private String description;

    BetStatus(String description,String value){
        this.description = description;
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public String getDescription() {
        return description;
    }
}
