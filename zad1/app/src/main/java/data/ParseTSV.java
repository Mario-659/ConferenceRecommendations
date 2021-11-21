package data;

public class ParseTSV implements ParseStrategy {
    private int id;
    private String[] attr;
    private String[] wantedAttr;

    public ParseTSV(){};

    public void parseLine(String line){
        String[] data = line.split("\t");
        this.id = Integer.parseInt(data[0]);
        this.attr = data[1].split(",");
        this.wantedAttr = data[2].split(",");
    }

    public int getID(){return id;}
    public String[] getAttr(){return attr;}
    public String[] getWantedAttr(){return wantedAttr;}
}
