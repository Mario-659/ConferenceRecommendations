package tools;

import data.Person;

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

    public static int getRandInt(int max){
        return generator.nextInt(max);
    }

    public static int getRandInt(int min, int max){
        return generator.nextInt(max - min) + min;
    }

    public static int getRandInt(int min, int max, int exclude){
        while(true){
            int number = getRandInt(min, max);
            if(number != exclude) return number;
        }
    }
}
