package fileReader;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;


public class FileReaderTest {

    @Test public void readTxtFile(){
        FileReader fileReader = new FileReader(new TxtStrategy());
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\testInput.txt";

        try{
            fileReader.readFile(path);
            List<String> data = fileReader.getData();
            assertEquals("1\tDEVELOPER\tINVESTOR,DEVELOPER", data.get(0));
            assertEquals("13\tMARKETING\tMARKETING,SALES", data.get(data.size()-1));
            assertEquals(13, data.size());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        String invalidPath = System.getProperty("user.dir") + "\\src\\test\\java\\fileReader\\input.txt";
        assertThrows(IOException.class,  () -> fileReader.readFile(invalidPath));

    }



}
