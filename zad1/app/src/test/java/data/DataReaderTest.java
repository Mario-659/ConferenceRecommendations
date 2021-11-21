package data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class DataReaderTest {
    @Test public void TSVData() {
        List<String> TSVData = new ArrayList<String>();
        TSVData.add("1\tDEVELOPER\tINVESTOR,DEVELOPER");
        TSVData.add("6\tARCHITECT\tINVESTOR,PROJECT_MANAGER,DEVELOPER");
        TSVData.add("13\tMARKETING\tMARKETING,SALES");

        DataReader population = new DataReader(TSVData, new ParseTSV());
        assertEquals(1,population.getPerson(0).getId());
        assertEquals(6,population.getPerson(1).getId());
        assertEquals(13,population.getPerson(2).getId());

        assertEquals(3, population.size());
    }
}

