package algorithm.mate;

import algorithm.mate.crossover.Crossover;
import algorithm.mate.selection.Selection;
import state.Genome;

import java.util.List;

public class Mate {
     private final Crossover crossover;
     private final Selection selection;

     public Mate(Crossover crossover, Selection selection){
         this.crossover = crossover;
         this.selection = selection;
     }

     public List<Genome> mate(List<Genome> population){
        List<Genome> parents = selection.select(population);
        return crossover.crossover(parents);
     }
}