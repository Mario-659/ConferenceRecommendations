package app;

import data.DataReader;
import data.ParseTSV;
import fileReader.FileReader;
import fileReader.TxtStrategy;
import state.State;

public class App {
    private static final int NUM_OF_CONNECTIONS = 5;
    private static final int MAX_ITERATIONS = 1000;

    public App(String path, int numOfConnections){
        readFile(path);
        parseData();
        state = new State(dataReader.getPersons(), numOfConnections);
        initialScore = state.getScore();
        System.out.println("Initial state: " + "\n" + state + "\n");
    }

    public App(String path){ this(path, NUM_OF_CONNECTIONS);}

    public void run(){
        int previousScore = initialScore;
        for(int i=0; i<MAX_ITERATIONS; i++){
            state.update();
            int currentScore = state.getScore();
            int change = currentScore - previousScore;
            System.out.println("Testing configuration number " + (i+1) + " Score of configuration: " + currentScore + " Change: " + change);
            if(change <= 0) break;
            previousScore = currentScore;
        }
        System.out.println("\n\n");
        System.out.println("End configuration:\n" + state);
    }

    public State getState(){ return state;}

    private FileReader fileReader;
    private DataReader dataReader;
    private final State state;
    private final int initialScore;

    private void readFile(String path){
        fileReader = new FileReader(new TxtStrategy());
        try{
            fileReader.readFile(path);
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(1);
        }
    }

    private void parseData(){
        dataReader = new DataReader(fileReader.getData(), new ParseTSV());
    }
}
