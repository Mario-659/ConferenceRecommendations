package algorithm.mate.crossover;

import state.Genome;

import java.util.List;

public interface Crossover {
    List<Genome> crossover(Genome parent1, Genome parent2);

    List<Genome> crossover(List<Genome> parents);
}
