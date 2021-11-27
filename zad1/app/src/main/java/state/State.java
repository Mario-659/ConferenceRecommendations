package state;

import data.Person;
import tools.Rand;

import java.util.ArrayList;
import java.util.List;

//TODO not actually a DNA, a DNA is all connections of a person, change name of this class

public class State {
    private static final int NUM_OF_CONNECTIONS = 5;

    List<Genome> bestGenomes;
    int score;

    private void evaluate(){
        int value = 0;
        for (Genome genome : bestGenomes) { value += genome.getFitness(); }
        this.score = value;
    }

    public State(List<Person> persons, int numOfConnections){
        bestGenomes = new ArrayList<>();
        for (Person person : persons) {
            List<Person> connections = Rand.makeRandConnections(persons, person, numOfConnections);
            bestGenomes.add(new Genome(person, connections));
        }
        evaluate();
    }

    public State(List<Person> persons) {this(persons, NUM_OF_CONNECTIONS);}

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Value of configuration: ");
        string.append(score);
        for (Genome genome :
                bestGenomes) {
            string.append("\n");
            string.append(genome.toString());
        }
        return string.toString();
    }

    public int getScore(){return score;}
}
