package state;

import algorithm.crossover.RankSelection;
import algorithm.mutation.RandomMutation;
import data.Person;
import tools.Rand;

import java.util.ArrayList;
import java.util.List;

//TODO add extracting best genomes
public class State {
    private static final int NUM_OF_CONNECTIONS = 5;

    List<Population> populations;
    List<Genome> bestGenomes;
    int score;

    private void evaluate(){
        int value = 0;
        for (Genome genome : bestGenomes) { value += genome.getFitness(); }
        this.score = value;
    }

    private void setBestGenomes(){
        List<Genome> genomes = new ArrayList<>();
        for (Population population : populations) {
            genomes.add(population.getBestGenome());
        }
        bestGenomes = genomes;
    }

    public State(List<Person> persons, int numOfConnections){
        bestGenomes = new ArrayList<>();
        for (Person person : persons) {
            List<Person> connections = Rand.makeRandConnections(persons, person, numOfConnections);
            bestGenomes.add(new Genome(person, connections));
        }
        populations = new ArrayList<>();
        for (Genome genome : bestGenomes) {
            populations.add(new Population(genome, new RandomMutation(persons), new RankSelection()));
        }
        evaluate();
    }

    public State(List<Person> persons) {this(persons, NUM_OF_CONNECTIONS);}

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Value of configuration: ");
        string.append(score);
        for (Genome genome : bestGenomes) {
            string.append("\n");
            string.append(genome.toString());
        }
        return string.toString();
    }
    public int getScore(){return score;}

    public void update(){
        for (Population population : populations) {
            population.nextGeneration();
        }
        setBestGenomes();
        evaluate();
    }
}
