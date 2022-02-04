package state;

import algorithm.Algorithm;
import data.Person;

import java.util.ArrayList;
import java.util.List;

public class Genome {
    private final Person person;
    private List<Person> connections;
    private int fitness;

    public Genome(Person person, List<Person> connections){
        this.person = person;
        this.connections = new ArrayList<>();
        for (Person personToAdd : connections) {
            if(personToAdd.getId() != this.person.getId()) this.connections.add(personToAdd);
        }
        evaluateFitness();
    }

    private void evaluateFitness(){
        fitness = Algorithm.evaluateFitness(person, connections);
    }

    public int getFitness() {
        return fitness;
    }

    public Person getPerson(){return person;}

    public List<Person> getConnections(){
        return new ArrayList<>(connections);
    }

    public String toString(){
        StringBuilder string = new StringBuilder("Person id: " + person.getId() + " Fitness: " + fitness + " Recommendations: {");
        for (Person person : connections) {
            string.append(" ");
            string.append(person.getId());
            string.append(",");
        }
        string.append("}");
        return string.toString();
    }
}
