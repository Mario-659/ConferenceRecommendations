package algorithm.crossover;

import data.Person;
import state.Genome;

import java.util.*;

public abstract class Crossover {

    //not perfect solution, connections that are different in two genomes have the same chance of being chosen as the ones which are mutual
    public Genome cross(Genome genome1, Genome genome2){
        assert genome1.getPerson().getId() == genome2.getPerson().getId(): "To crossover genomes must have the same person";

        //make list of all connections without duplicates
        List<Person> connections1 = genome1.getConnections();
        List<Person> connections2 = genome2.getConnections();
        HashSet<Person> allConnections = new HashSet<Person>(connections1);
        allConnections.addAll(connections2);

        //shuffle connections
        List<Person> allConnectionsList = new ArrayList<Person>(allConnections);
        Collections.shuffle(allConnectionsList);

        List<Person> newConnections = new ArrayList<>();
        Iterator<Person> iterator = allConnections.iterator();
        for(int i=0; i<connections1.size(); i++){
            newConnections.add(allConnectionsList.get(i));
        }
        return new Genome(genome1.getPerson(), newConnections);
    }

    //TODO break down this method (now it do selection and crossover)
    abstract public List<Genome> cross(List<Genome> genomes);
}
