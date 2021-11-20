package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TxtStrategy implements ReadStrategy {
    public List<String> readFile(String path) throws IOException {
        Path fileName = Path.of(path);
        List<String> data = Files.readAllLines(fileName);
        return data;
    }
}










    //new Person from line
//    public static Person getPerson(String data) throws RuntimeException{
//        String[] personData = data.split("\t");
//        int id = Integer.parseInt(personData[0]);
//        String[] attributes = personData[1].split(",");
//        String[] wantedAttr = personData[2].split(",");
//        return new Person(id, attributes, wantedAttr);
//    }

//    public static Person[] getPersons(String[] data){
//        Person[] persons = new Person[data.length];
//        for (int i=0; i< data.length; i++){
//            persons[i] = getPerson(data[i]);
//        }
//        return persons;
//    }

//    public static Person[] readPersons(String path){
//        Person[] persons;
//        try {
//            String data = readFile(path);
//            String[] lines = data.split("\n");
//            persons = getPersons(lines);
//        }
//        catch(IOException e){
//            e.printStackTrace();
//
//            return null;
//        }
//        return persons;
//    }

