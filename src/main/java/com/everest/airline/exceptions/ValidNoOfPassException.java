package com.everest.airline.exceptions;

public class ValidNoOfPassException extends RuntimeException{
    public ValidNoOfPassException(){
        super("Please enter valid number of passengers");
    }
}
