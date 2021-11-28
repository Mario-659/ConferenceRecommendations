package algorithm.mate.selection;

import state.Genome;

import java.util.List;

public interface Selection {
    List<Genome> select(List<Genome> genomes);
}
