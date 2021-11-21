package state.crossover;

import state.Genome;

public interface Crossover {
    Genome cross(Genome genome1, Genome genome2);
}
