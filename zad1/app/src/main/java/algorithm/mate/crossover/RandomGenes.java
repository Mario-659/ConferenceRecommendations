package algorithm.mate.crossover;

import data.Person;
import state.Genome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RandomGenes implements Crossover{

    @Override
    public List<Genome> crossover(Genome parent1, Genome parent2) {
        assert parent1.getPerson().getId() == parent2.getPerson().getId(): "To crossover genomes must have the same person";

        //make list of all connections without duplicates
        List<Person> connections1 = parent1.getConnections();
        List<Person> connections2 = parent2.getConnections();
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
        newGenomes.add(new Genome(parent1.getPerson(), newConnections));

        //make second genome
        newConnections.clear();
        for(int i=allConnections.size()-1; newConnections.size()<connections1.size(); i--){
            newConnections.add(allConnectionsList.get(i));
        }

        //second genome
        newGenomes.add(new Genome(parent1.getPerson(), newConnections));

        return newGenomes;
    }

    @Override
    public List<Genome> crossover(List<Genome> parents) {
        assert parents.size() % 2 == 0: "Not even";

        List<Genome> offspring = new ArrayList<>();
        for(int i=0; i<parents.size()-1; i+=2){
            List<Genome> genomesToAdd = crossover(parents.get(i), parents.get(i+1));
            offspring.addAll(genomesToAdd);
        }
        return offspring;
    }
}
