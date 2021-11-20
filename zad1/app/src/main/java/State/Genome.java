package State;

import algorithm.Algorithm;
import population.Person;

import java.util.ArrayList;
import java.util.List;

//TODO it is not actually a genome, genome is each connection, change name of this class
public class Genome {
    private Person person;
    private List<Person> connections;
    private int fitness;

    public Genome(Person person, List<Person> connections){
        this.person = person;
        this.connections = new ArrayList<Person>();
        for (Person personToAdd :
                connections) {
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

    public String toString(){
        StringBuilder string = new StringBuilder("Person id: " + person.getId() + " Fitness: " + fitness + " Recommendations: {");
        for (Person person :
                connections) {
            string.append(" ");
            string.append(person.getId());
            string.append(",");
        }
        string.append("}");
        return string.toString();
    }
}
