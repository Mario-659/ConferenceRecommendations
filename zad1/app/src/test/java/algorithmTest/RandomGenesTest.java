package algorithmTest;

import algorithm.mate.crossover.RandomGenes;
import data.Person;
import org.junit.Test;
import state.Genome;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class RandomGenesTest {
    private final List<Person> persons = Arrays.asList(
            new Person(1, new String[]{"DEVELOPER"}, new String[]{"DEVELOPER","ARCHITECT","PROBLEM_SOLVER","DESIGNER"}),
            new Person(2, new String[]{"INVESTOR"}, new String[]{"DEVELOPER","PROBLEM_SOLVER","ARCHITECT"}),
            new Person(3, new String[]{"MARKETING"}, new String[]{"INVESTOR","PROJECT_MANAGER","DEVELOPER"}),
            new Person(4, new String[]{"ARCHITECT"}, new String[]{"DEVELOPER","PROBLEM_SOLVER"}),
            new Person(5, new String[]{"PROBLEM_SOLVER"}, new String[]{"INVESTOR","PROBLEM_SOLVER","DEVELOPER"}));

    private Genome genome1 = new Genome(persons.get(0), persons.subList(1, 4));
    private Genome genome2 = new Genome(persons.get(0), persons.subList(1, 4));

    private RandomGenes randomGenes = new RandomGenes();

    private List<Genome> offspring = randomGenes.crossover(genome1, genome2);

    @Test
    public void sameNumOfConnections(){
        assertEquals(genome1.getConnections().size(), offspring.get(0).getConnections().size());
        assertEquals(genome1.getConnections().size(), offspring.get(1).getConnections().size());
    }

    @Test
    public void noDuplicates(){
        List<Person> connections = offspring.get(0).getConnections();
        HashSet<Person> connectionsHash = new HashSet<>(connections);
        assertEquals(connectionsHash.size(), connections.size());

        connections = offspring.get(1).getConnections();
        connectionsHash = new HashSet<>(connections);
        assertEquals(connectionsHash.size(), connections.size());
    }

    @Test
    public void sameNumOfGenomes(){
        assertEquals(2, offspring.size());
    }

}
