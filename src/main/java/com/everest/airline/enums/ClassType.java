package com.everest.airline.enums;

public enum ClassType {
    ECONOMIC("economic_seats_avaliable"), FIRSTCLASS("firstclass_seats_avaliable"), SECONDCLASS("secondclass_seats_avaliable");

    private String string;

    ClassType(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
