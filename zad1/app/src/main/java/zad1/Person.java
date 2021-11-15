package zad1;


import java.util.Arrays;
import java.util.HashSet;

public class Person {
    Person(int id, String[] attributes, String[] wantedAttributes){
        this.id = id;
        this.attributes = new HashSet<String>();
        this.wantedAttributes = new HashSet<String>();
        addAttr(attributes);
        addWantedAttr(wantedAttributes);
    }

    private int id;

    private HashSet<String> attributes;

    private HashSet<String> wantedAttributes;

    private void addAttr(String[] attr){
        attributes.addAll(Arrays.asList(attr));
    }

    private void addWantedAttr(String[] attr){
        wantedAttributes.addAll(Arrays.asList(attr));
    }

    public int getId(){
        return this.id;
    }

    public HashSet<String> getAttributes(){
        return this.attributes;
    }

    public HashSet<String> getWantedAttributes(){
        return this.wantedAttributes;
    }
}
