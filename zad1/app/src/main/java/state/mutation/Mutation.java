package state.mutation;

import state.Genome;

import java.util.List;

public interface Mutation {
    Genome mutate(Genome genome);

    List<Genome> mutate(List<Genome> genomes);
}
