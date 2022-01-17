package com.everest.airline.database;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    public void isDirectoryEmptyTest(){
        assertNotNull(DataParser.multiFileReader(), "There are no files in the directory");
    }

    @Test
    public void isFileTest() {
        for(File file : DataParser.multiFileReader()){
            assertTrue(file.isFile(),"Provided not a file");
        }
    }

}