package com.everest.airline.exceptions;

public class DatabaseEmptyException extends RuntimeException {
    public DatabaseEmptyException() {
        super("Database is empty, Please insert database in dbConfig");
    }
}
