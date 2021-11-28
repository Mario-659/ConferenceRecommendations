//package algorithm.mate.crossover;
//
//import data.Person;
//import state.Genome;
//import tools.Rand;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class OnePoint implements Crossover{
//    @Override
//    public List<Genome> crossover(Genome parent1, Genome parent2) {
//        List<Person> connections1 = parent1.getConnections();
//        List<Person> connections2 = parent2.getConnections();
//
//        Comparator<Person> comparator = (o1, o2) -> Integer.signum(o1.getId() - o2.getId());
//
//        connections1.sort(comparator);
//        connections2.sort(comparator);
//
//
//        int point = Rand.getRandInt(connections1.size()-1);
//
//        List<Person> newConnections1 = new ArrayList<>();
//        List<Person> newConnections2 = new ArrayList<>();
//
//        if(point == 0 || point == connections1.size()-1 || point == 1 || point==connections1.size()-2){
//            newConnections1.add(connections1.get(point));
//            newConnections1.addAll(connections2.subList())
//        }
//
//        Person participant = parent1.getPerson();
//        List<Genome> offspring = new ArrayList<>();
//        offspring.add(new Genome(participant, newConnections1));
//        offspring.add(new Genome(participant, newConnections2));
//
//        return offspring;
//    }
//
//    @Override
//    public List<Genome> crossover(List<Genome> parents) {
//        return null;
//    }
//}
