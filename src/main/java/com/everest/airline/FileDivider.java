package com.everest.airline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileDivider {
    private String[] filenames={"1001","1002","1003","1004","1005","1006"};
    private BufferedReader br=null;
    private BufferedWriter bw=null;
    public void testFileDivider(){
       try{
           br = new BufferedReader(new FileReader("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/flightData.txt"));
//           for(int i=0;i<)


       }catch (IOException e){
           e.printStackTrace();
       }
    }



}
