package state;

import data.Person;
import state.crossover.Crossover;
import state.mutation.Mutation;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private final Mutation mutation;
    private final Crossover crossover;
    private List<Genome> genomes;


    public Population(Genome initialGenome, Mutation mutation, Crossover crossover){
        this.mutation = mutation;
        this.crossover = crossover;
        populate(initialGenome);
    }

    Genome getBestGenome(){
        Genome bestGenome = null;
        int bestFitness = -1;
        for (Genome genome : genomes) {
            int fitness = genome.getFitness();
            if(fitness > bestFitness) {
                bestGenome = genome;
                bestFitness = fitness;
            }
        }
        return bestGenome;
    }

    private void populate(Genome genome){
        genomes = new ArrayList<>();
        List<Person> initialConnections = genome.getConnections();



    }

    private void mate(){

    }

    private void mutate(){ genomes = mutation.mutate(genomes);}

    void nextGeneration(){
        mate();
        mutate();
    }
}
