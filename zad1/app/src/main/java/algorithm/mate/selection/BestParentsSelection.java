package algorithm.mate.selection;

import state.Genome;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestParentsSelection implements Selection{
    @Override
    public List<Genome> select(List<Genome> genomes) {
        assert genomes.size() % 2 == 0;

        Comparator<Genome> comparator = (genome1, genome2) -> Integer.signum(genome2.getFitness() - genome1.getFitness());
        List<Genome> sorted = new ArrayList<>(genomes);
        sorted.sort(comparator);

        return sorted.subList(0, sorted.size()/2);
    }
}
