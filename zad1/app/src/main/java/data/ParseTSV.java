package data;

public class ParseTSV implements ParseStrategy {
    private int id;
    private String[] attr;
    private String[] wantedAttr;

    public ParseTSV(){}

    @Override
    public void parseLine(String line){
        String[] data = line.split("\t");
        this.id = Integer.parseInt(data[0]);
        this.attr = data[1].split(",");
        this.wantedAttr = data[2].split(",");
    }

    @Override
    public int getID(){return id;}

    @Override
    public String[] getAttr(){return attr;}

    @Override
    public String[] getWantedAttr(){return wantedAttr;}
}
