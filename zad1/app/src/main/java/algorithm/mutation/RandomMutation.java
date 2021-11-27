package algorithm.mutation;

import data.Person;
import state.Genome;
import tools.Rand;

import java.util.ArrayList;
import java.util.List;

public class RandomMutation implements Mutation {
    private final List<Person> allPersons;

    public RandomMutation(List<Person> allPersons){
        this.allPersons = allPersons;
    }

    @Override
    public Genome mutate(Genome genome) {
        return null;
    }

    @Override
    public Genome mutate(Genome genome, int numOfMutations) {
        //TODO refactor to makePossibleConnections method
        List<Person> oldConnections = genome.getConnections();
        List<Person> possibleMutations = new ArrayList<>();
        Person personToExclude = genome.getPerson();
        for (Person person : allPersons) {
            if(person.getId() != personToExclude.getId() && !oldConnections.contains(person)){
                possibleMutations.add(person);
            }
        }
        assert possibleMutations.size() >= numOfMutations: "Number of mutation is greater than number of possible mutations";

        List<Person> newConnections = new ArrayList<>(oldConnections);
        while(numOfMutations > 0){
            int oldConnection = Rand.getRandInt(oldConnections.size() - 1);
            int newConnection = Rand.getRandInt( possibleMutations.size() - 1);

            newConnections.set(oldConnection, possibleMutations.get(newConnection));
            numOfMutations--;
        }
        return new Genome(personToExclude, newConnections);
    }

    @Override
    public List<Genome> mutate(List<Genome> genomes) {
        return null;
    }
}
