package state;

import State.DNA;
import org.junit.Test;
import population.Person;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DNATest {
    private final List<Person> persons = Arrays.asList(
            new Person(1, new String[]{"DEVELOPER"}, new String[]{"DEVELOPER","ARCHITECT","PROBLEM_SOLVER","DESIGNER"}),
            new Person(2, new String[]{"INVESTOR"}, new String[]{"DEVELOPER","PROBLEM_SOLVER","ARCHITECT"}),
            new Person(3, new String[]{"MARKETING"}, new String[]{"INVESTOR","PROJECT_MANAGER","DEVELOPER"}));

    DNA dna = new DNA(persons, 2);

    @Test public void valueAfterCreation(){
        assertEquals(10, dna.getValue());
    }
}
