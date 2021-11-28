package appTest;

import app.App;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class efficiencyTest {
    private final String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testInput.txt";
    private final int NUM_OF_RUNS = 100;
    private List<Integer> changes = new ArrayList<>();

    private int runApp(){
        App app = new App(path);
        int initial = app.getState().getScore();
        app.run();
        int endValue = app.getState().getScore();
        return endValue - initial;
    }

    private void testApp(){
        for(int i=0; i<NUM_OF_RUNS; i++){
            changes.add(runApp());
        }
        int average = calcAverage();
        System.out.println("Average change: " + average);
    }

    private int calcAverage(){
        long sum = 0;
        for (Integer change : changes) {
            sum += change;
        }
        return (int) sum/changes.size();

    }

    @Test
    public void runTest(){
        testApp();
    }
}
