package com.everest.airline.enums;

public enum ClassFare {
    ECONOMIC(75),SECONDCLASS(100),FIRSTCLASS(200);
    private double cost;

    ClassFare(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
