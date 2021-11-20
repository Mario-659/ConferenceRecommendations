package fileReader;

import java.util.List;
import java.io.IOException;

public interface ReadStrategy {
    List<String> readFile(String path) throws IOException;
}
