package State;

import population.Population;

import java.util.HashMap;
import java.util.HashSet;

public class State {
    private Population population;

    HashMap<Integer, HashSet<String>> connections;

    public State(Population population, int numberOfConnections){
        this.connections = new HashMap<Integer, HashSet<String>>();
        this.population = population;
        for(int i=0; i< population.size();i++){
            int id = population.getPerson(i).getId();
            connections.put(id, new HashSet<String>(numberOfConnections));
        }
    }
}
