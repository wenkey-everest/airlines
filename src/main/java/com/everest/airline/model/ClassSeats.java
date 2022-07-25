package com.everest.airline.model;

public class ClassSeats {
    private int seatsAvailable;
    private int classCapacity;
    private double classFare;

    public ClassSeats(int SeatsAvailable, int ClassCapacity) {
        this.seatsAvailable = SeatsAvailable;
        this.classCapacity = ClassCapacity;

    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(int classCapacity) {
        this.classCapacity = classCapacity;
    }

    public double getClassFare() {
        return classFare;
    }

    public void setClassFare(double classFare) {
        this.classFare = classFare;
    }
}
