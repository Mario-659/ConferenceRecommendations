package tools;

import org.junit.Test;
import population.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RandTest {
    private final List<Person> persons = Arrays.asList(
            new Person(1, new String[]{"DEVELOPER"}, new String[]{"DEVELOPER","ARCHITECT","PROBLEM_SOLVER","DESIGNER"}),
            new Person(2, new String[]{"INVESTOR"}, new String[]{"DEVELOPER","PROBLEM_SOLVER","ARCHITECT"}),
            new Person(3, new String[]{"MARKETING"}, new String[]{"INVESTOR","PROJECT_MANAGER","DEVELOPER"}));

    @Test public void makeConnNotMutating(){
        List<Person> prevState = new ArrayList<>(persons);

        Rand.makeRandConnections(persons, persons.get(0), 2);
        assertArrayEquals(prevState.toArray(), persons.toArray());
    }

    @Test public void makeConnThrows(){
        Throwable e = assertThrows(AssertionError.class, ()->Rand.makeRandConnections(persons, persons.get(1), 3));
        assertEquals("Size of list must be greater than number of connections", e.getMessage());

        e = assertThrows(AssertionError.class, ()->Rand.makeRandConnections(persons, persons.get(1), 5));
        assertEquals("Size of list must be greater than number of connections", e.getMessage());
    }

}
