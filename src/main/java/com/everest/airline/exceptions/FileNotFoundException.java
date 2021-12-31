package com.everest.airline.exceptions;

public class FileNotFoundException extends RuntimeException{
   public FileNotFoundException(Throwable e){
       super("file is not present",e);
   }
}
