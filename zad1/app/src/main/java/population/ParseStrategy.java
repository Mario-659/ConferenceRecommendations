package population;

//Parsing strategy for different types of data (csv, tsv)
public interface ParseStrategy {
    void parseLine(String line);
    int getID();
    String[] getAttr();
    String[] getWantedAttr();
}
