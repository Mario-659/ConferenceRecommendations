package tools;

import population.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Rand {
    private static Random generator = new Random();

    public static List<Person> makeRandConnections(List<Person> persons, Person exclude, int numOfConnections){
        assert persons.size() > numOfConnections: "Size of list must be greater than number of connections";
        List<Person> randList = new ArrayList<>(persons);
        Collections.shuffle(randList);
        List<Person> randConnections = new ArrayList<>();

        for (Person person : persons) {
            if(person.getId() != exclude.getId()) randConnections.add(person);
            if(randConnections.size() == numOfConnections) break;
        }
        return randConnections;
    }

}
