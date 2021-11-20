package State;

import population.Person;
import tools.Rand;

import java.util.ArrayList;
import java.util.List;

//TODO not actually a DNA, a DNA is all connections of a person, change name of this class
public class DNA {
    List<Genome> genomes;
    int value;

    private void evaluate(){
        int score = 0;
        for (Genome genome :
                genomes) {
            score += genome.getFitness();
        }
        this.value = score;
    }

    public DNA(List<Person> persons, int numOfConnections){
        genomes = new ArrayList<>();
        for (Person person :
                persons) {
            List<Person> connections = Rand.makeRandConnections(persons, person, numOfConnections);
            genomes.add(new Genome(person, connections));
        }
        evaluate();
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Value of configuration: ");
        string.append(value);
        for (Genome genome :
                genomes) {
            string.append("\n");
            string.append(genome.toString());
        }
        return string.toString();
    }

    public int getValue(){return value;}
}
