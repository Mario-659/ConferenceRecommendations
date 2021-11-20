package algorithm;

import population.Person;

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

    public static int comparePersons(Person person1, Person person2){
        if(person1==null || person2==null) return 0;
        assert person1.getId() != person2.getId(): "Cannot compare persons with the same id. Id of a person: " + person1.getId();

        return compareAttr(person1.getWantedAttributes(), person2.getWantedAttributes());
    }

    public static int evaluateFitness(Person person, List<Person> connections){
        int fitness = 0;
        HashSet<String> attr1 = person.getWantedAttributes();
        for (Person person2:connections) {
            fitness += compareAttr(attr1, person2.getWantedAttributes());
        }
        return fitness;
    }
}