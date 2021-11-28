package algorithmTest;

import algorithm.Algorithm;
import data.Person;
import data.ParseTSV;
import data.DataReader;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmTest {



    @Test public void compareAttr() {
        List<String> TSVData = new ArrayList<String>();
        TSVData.add("1\tDEVELOPER\tINVESTOR,DEVELOPER");
        TSVData.add("6\tARCHITECT\tINVESTOR,PROJECT_MANAGER,DEVELOPER");
        TSVData.add("13\tMARKETING\tMARKETING,SALES");
        DataReader population = new DataReader(TSVData, new ParseTSV());

        Person person1 = population.getPerson(0);
        Person person2 = population.getPerson(1);

        assertEquals(2, Algorithm.compareAttr(person1.getWantedAttributes(), person2.getWantedAttributes()));}
}