package state;

import org.junit.Test;
import data.Person;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StateTest {
    private final List<Person> persons = Arrays.asList(
            new Person(1, new String[]{"DEVELOPER"}, new String[]{"DEVELOPER","ARCHITECT","PROBLEM_SOLVER","DESIGNER"}),
            new Person(2, new String[]{"INVESTOR"}, new String[]{"DEVELOPER","PROBLEM_SOLVER","ARCHITECT"}),
            new Person(3, new String[]{"MARKETING"}, new String[]{"INVESTOR","PROJECT_MANAGER","DEVELOPER"}));

    State state = new State(persons, 2);

    @Test public void valueAfterCreation(){
        assertEquals(10, state.getScore());
    }
}
