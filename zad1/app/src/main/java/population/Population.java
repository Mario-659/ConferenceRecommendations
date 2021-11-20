package population;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private final ParseStrategy strategy;

    private List<Person> persons;

    public Population(List<String> data, ParseStrategy strategy){
        this.strategy = strategy;
        this.persons = new ArrayList<Person>();
        readPersons(data);
    }

    private void readPersons(List<String> data){
        for (String line: data) {
            this.strategy.parseLine(line);
            int id = this.strategy.getID();
            String[] attr = this.strategy.getAttr();
            String[] wantedAttr = this.strategy.getWantedAttr();
            persons.add(new Person(id, attr, wantedAttr));
        }
    }

    public Person getPerson(int index){
        return persons.get(index);
    }

    public int size(){ return persons.size();}
}
