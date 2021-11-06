package zad1;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;

import static org.junit.Assert.*;


public class FileReaderTest {
    @Test public void readPersonsTest(){
        FileReader fileReader;
        Person[] persons = FileReader.readPersons(System.getProperty("user.dir") + "\\src\\test\\java\\zad1\\testInput.txt");
        //TODO assert exceptions, check how it handles path string as name of the file

        for(int i=0; i<persons.length; i++){
            assertEquals(i+1, persons[i].getId());
        }
    }


}
