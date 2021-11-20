package zad1;


import person.Person;

import java.util.HashSet;

public class Algorithm {

    private static int CONNECTION_VALUE = 1;

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

        int value = 0;
        value += compareAttr(person1.getAttributes(), person2.getWantedAttributes());
        value += compareAttr(person1.getWantedAttributes(), person2.getAttributes());

        return value;
    }
}


