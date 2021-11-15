package zad1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class State {
    // might not be useful
//    public Person[] persons;

    private HashMap<Person, Person> connections;

    //creates state with random connections
    public State(Person[] persons){}

    public State(HashMap<Person, Person> connections){
        this.connections = new HashMap<Person, Person>(connections);

//        ArrayList<Person> personsArray = new ArrayList<Person>();
//        connections.forEach( (person, connectedPerson) -> {
//            personsArray.add(person);
//            //might add check if connection not null (when length of persons%2 == 1)
//            personsArray.add(connectedPerson);
//        });
//
//        personsArray.toArray(this.persons);
        stateValue = evaluateState();
    }

    //value of all connections
    private int stateValue;

    //calculates value of all connections
    private int evaluateState() {
        int value = 0;

        //TODO can be improved
        for (Person person1: connections.keySet()) {
            value += Algorithm.comparePersons(person1, connections.get(person1));
        }
        return value;
    }

    //updates connections, stateValue should be equal or higher than before
    public void update(){
        for(Person person1: connections.keySet()){


        }
    };

    public int getStateValue(){
        return stateValue;
    }
}
