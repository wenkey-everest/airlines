package com.everest.airline.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataParser {
    public static BufferedReader singleFileReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/flightData.txt"));
    }
    public static File[] multiFileReader(){
        File dir = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights");
        return dir.listFiles();
    }
}
