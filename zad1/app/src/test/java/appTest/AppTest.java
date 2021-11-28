package appTest;

import app.App;
import org.junit.Test;


public class AppTest {
    private final String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testInput.txt";
    App app = new App(path);

    @Test
    public void runs(){
        app.run();
    }
}
