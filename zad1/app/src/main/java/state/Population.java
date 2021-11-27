package state;

import data.Person;
import algorithm.crossover.Crossover;
import algorithm.mutation.Mutation;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private static final int SIZE_OF_POPULATION = 4;

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
        for(int i=0; i<SIZE_OF_POPULATION; i++){
            genomes.add(mutation.mutate(genome, 3));
        }
    }

    private void mate(){
        genomes = crossover.cross(genomes);
    }

    private void mutate(){ genomes = mutation.mutate(genomes);}

    void nextGeneration(){
        mate();
        mutate();
    }
}
