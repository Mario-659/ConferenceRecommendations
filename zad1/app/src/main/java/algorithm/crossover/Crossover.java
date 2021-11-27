package algorithm.crossover;

import data.Person;
import state.Genome;

import java.util.*;

public abstract class Crossover {

    //TODO refactor
    //not perfect solution, connections that are different in two genomes have the same chance of being chosen as the ones which are mutual
    public List<Genome> cross(Genome genome1, Genome genome2){
        assert genome1.getPerson().getId() == genome2.getPerson().getId(): "To crossover genomes must have the same person";

        //make list of all connections without duplicates
        List<Person> connections1 = genome1.getConnections();
        List<Person> connections2 = genome2.getConnections();
        HashSet<Person> allConnections = new HashSet<Person>(connections1);
        allConnections.addAll(connections2);

        //shuffle connections
        List<Person> allConnectionsList = new ArrayList<Person>(allConnections);
        Collections.shuffle(allConnectionsList);

        //make first genome
        List<Person> newConnections = new ArrayList<>();
        for(int i=0; i<connections1.size(); i++){
            newConnections.add(allConnectionsList.get(i));
        }

        List<Genome> newGenomes = new ArrayList<>();
        //first genome
        newGenomes.add(new Genome(genome1.getPerson(), newConnections));

        //make second genome
        newConnections.clear();
        for(int i=allConnections.size()-1; newConnections.size()<connections1.size(); i--){
            newConnections.add(allConnectionsList.get(i));
        }

        //second genome
        newGenomes.add(new Genome(genome1.getPerson(), newConnections));

        return newGenomes;
    }

    //TODO break down this method (now it does selection and crossover)
    abstract public List<Genome> cross(List<Genome> genomes);
}
