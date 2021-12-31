package com.everest.airline.exceptions;

public class FileNotWrittenException extends RuntimeException{
    public FileNotWrittenException(Throwable err){
        super("flight not stored in the file", err);
    }
}
