package com.everest.airline.enums;

public enum ClassType {
    ECONOMIC("economic"), FIRSTCLASS("firstClass"), SECONDCLASS("secondClass");

    private String string;

    ClassType(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
