package fileReader;

import java.io.IOException;
import java.util.List;

public class FileReader {
    private final ReadStrategy strategy;

    private List<String> lines;

    public FileReader(ReadStrategy strategy){
        this.strategy = strategy;
    }

    public void readFile(String path) throws IOException {
        this.lines = strategy.readFile(path);
    }

    public List<String> getData(){
        return this.lines;
    }
}
