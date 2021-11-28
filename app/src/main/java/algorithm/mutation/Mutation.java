package algorithm.mutation;

import state.Genome;

import java.util.List;

public interface Mutation {
    Genome mutate(Genome genome);

    Genome mutate(Genome genome, int numOfMutations);

    List<Genome> mutate(List<Genome> genomes);
}
