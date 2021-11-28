package data;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;



public class PersonTest{

    String[] attr = new String[]{"DEVELOPER", "INVESTOR"};
    String[] wantedAttr = new String[]{"PROBLEM_SOLVER", "INVESTOR"};
    public Person testPerson = new Person(1, attr, wantedAttr);

    @Test public void testAttr(){
        HashSet<String> attr = testPerson.getAttributes();
        assertTrue(attr.contains("DEVELOPER"));
        assertTrue(attr.contains("INVESTOR"));
        assertFalse(attr.contains("PROBLEM_SOLVER"));
    }

    @Test public void testWantedAttr(){
        HashSet<String> attr = testPerson.getWantedAttributes();
        assertFalse(attr.contains("DEVELOPER"));
        assertTrue(attr.contains("INVESTOR"));
        assertTrue(attr.contains("PROBLEM_SOLVER"));
    }
}

