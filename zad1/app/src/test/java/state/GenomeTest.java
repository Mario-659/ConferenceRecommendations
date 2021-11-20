package state;

import State.Genome;
import org.junit.Test;
import static org.junit.Assert.*;
import population.Person;

import java.util.Arrays;
import java.util.List;

public class GenomeTest {
    private final List<Person> persons = Arrays.asList(
            new Person(1, new String[]{"DEVELOPER"}, new String[]{"DEVELOPER","ARCHITECT","PROBLEM_SOLVER","DESIGNER"}),
            new Person(2, new String[]{"INVESTOR"}, new String[]{"DEVELOPER","PROBLEM_SOLVER","ARCHITECT"}),
            new Person(3, new String[]{"MARKETING"}, new String[]{"INVESTOR","PROJECT_MANAGER","DEVELOPER"}));

    Genome genome = new Genome(persons.get(1), persons);

    @Test public void evaluatedFitness(){
        assertEquals(4, genome.getFitness());
    }

    @Test public void testToString(){
        assertEquals("Person id: 2 Fitness: 4 Recommendations: { 1, 3,}", genome.toString());
    }
}
