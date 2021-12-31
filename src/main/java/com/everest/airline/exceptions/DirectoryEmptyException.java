package com.everest.airline.exceptions;

public class DirectoryEmptyException extends RuntimeException{
    public DirectoryEmptyException(){
        super("Directory is empty, Please update the path");
    }
}
