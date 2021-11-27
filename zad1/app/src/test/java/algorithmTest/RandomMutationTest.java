package algorithmTest;

import algorithm.mutation.RandomMutation;
import data.Person;
import org.junit.Test;
import static org.junit.Assert.*;
import state.Genome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomMutationTest {
    private final List<Person> persons = Arrays.asList(
            new Person(1, new String[]{"DEVELOPER"}, new String[]{"DEVELOPER","ARCHITECT","PROBLEM_SOLVER","DESIGNER"}),
            new Person(2, new String[]{"INVESTOR"}, new String[]{"DEVELOPER","PROBLEM_SOLVER","ARCHITECT"}),
            new Person(3, new String[]{"MARKETING"}, new String[]{"INVESTOR","PROJECT_MANAGER","DEVELOPER"}),
            new Person(4, new String[]{"ARCHITECT"}, new String[]{"DEVELOPER","PROBLEM_SOLVER"}),
            new Person(5, new String[]{"PROBLEM_SOLVER"}, new String[]{"INVESTOR","PROBLEM_SOLVER","DEVELOPER"}));

    private final List<Person> connections = new ArrayList<>(persons.subList(0, 3));
    Genome genome = new Genome(persons.get(1), connections);

    private final RandomMutation randomMutation = new RandomMutation(persons);
    Genome newGenome = randomMutation.mutate(genome, 2);

    @Test public void sameSize(){
        int oldSize = genome.getConnections().size();
        int newSize =  newGenome.getConnections().size();
        assertEquals(oldSize, newSize);
    }

    @Test public void madeChanges(){
        assertNotEquals(genome.getConnections(), newGenome.getConnections());
    }
}
