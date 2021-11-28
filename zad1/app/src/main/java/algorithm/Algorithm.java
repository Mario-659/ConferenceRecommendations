package algorithm;

import data.Person;

import java.util.HashSet;
import java.util.List;

public class Algorithm {
    private static final int CONNECTION_VALUE = 1;

    public static int compareAttr(HashSet<String> attr1, HashSet<String> attr2){
        int value = 0;
        for (String attr: attr1) {
            if(attr2.contains(attr)) value += CONNECTION_VALUE;
        }
        return value;
    }

    public static int evaluateFitness(Person person, List<Person> connections){
        int fitness = 0;
        for (Person person2:connections) {
            assert person.getId() != person2.getId(): "Cannot compare persons with the same id. Id of a person: " + person.getId();

            fitness += compareAttr(person.getWantedAttributes(), person2.getAttributes());
        }
        return fitness;
    }
}