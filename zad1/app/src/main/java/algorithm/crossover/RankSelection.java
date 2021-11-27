package algorithm.crossover;

import algorithm.crossover.Crossover;
import state.Genome;

import java.util.ArrayList;
import java.util.List;

public class RankSelection extends Crossover {
    //rank selection for even number of genomes
    @Override
    public List<Genome> cross(List<Genome> genomes) {
        assert genomes.size() % 2 == 0: "Not even";

        List<Genome> offspring = new ArrayList<>();
        for(int i=0; i<genomes.size()-1; i+=2){
            List<Genome> genomesToAdd = cross(genomes.get(i), genomes.get(i+1));
            offspring.addAll(genomesToAdd);
        }
        return offspring;
    }
}
