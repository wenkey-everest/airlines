package com.everest.airline.validation;

import org.springframework.stereotype.Component;

@Component
public class ValidateData {
    public boolean validSeats(String flightClass,int noOfPass,int economicSeats, int firstClassSeats, int secondClassSeats){
        boolean check;
        switch (flightClass) {
            case "economic":
                check = validateSeats(noOfPass,economicSeats);
                break;
            case "firstClass":
                check = validateSeats(noOfPass,firstClassSeats);
                break;
            case "secondClass":
                check = validateSeats(noOfPass,secondClassSeats);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + flightClass);
        }
        return check;
    }


    public boolean validateSeats(int passengerCount,int availableSeats) {
        if(passengerCount<availableSeats)
        {
            return true;
        }
        return false;
    }
}
