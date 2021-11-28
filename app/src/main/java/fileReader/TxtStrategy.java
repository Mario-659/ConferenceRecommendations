package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TxtStrategy implements ReadStrategy {
    public List<String> readFile(String path) throws IOException {
        Path fileName = Path.of(path);
        return Files.readAllLines(fileName);
    }
}
