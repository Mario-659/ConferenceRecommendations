package appTest;

import app.App;
import data.DataReader;
import data.ParseTSV;
import fileReader.FileReader;
import fileReader.TxtStrategy;
import org.junit.Test;
import state.State;

public class AppTest {
    private final String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testInput.txt";
    App app = new App(path);

    @Test
    public void runs(){
        app.run();
    }
}
