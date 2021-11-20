//package zad1;
//
//import fileReader.FileReader;
//import person.Person;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import java.util.HashSet;
//
//public class AlgorithmTest {
//
//
//
//    @Test public void compareAttr() {
//        Person[] persons = FileReader.readPersons(System.getProperty("user.dir") + "\\src\\test\\java\\zad1\\testInput.txt");
//
//        assertEquals(0, Algorithm.compareAttr(persons[0].getAttributes(), persons[1].getWantedAttributes()));
//
//        assertEquals(1, Algorithm.compareAttr(persons[0].getAttributes(), persons[2].getWantedAttributes()));
//
//        for (Person person : persons) {
//            HashSet<String> attr1 = person.getAttributes();
//            HashSet<String> attr2 = person.getWantedAttributes();
//
//            assertEquals(Algorithm.compareAttr(attr1, attr2), Algorithm.compareAttr(attr2, attr1));
//        }
//
//        for(int i=0; i< persons.length; i++){
//            HashSet<String> attr1 = persons[i].getWantedAttributes();
//            int j = (i + 1) % persons.length;
//            HashSet<String> attr2 = persons[j].getWantedAttributes();
//
//            assertEquals(Algorithm.compareAttr(attr1, attr2), Algorithm.compareAttr(attr2, attr1));
//        }
//    }
//
//    @Test public void comparePersons(){
//        Person[] persons = FileReader.readPersons(System.getProperty("user.dir") + "\\src\\test\\java\\zad1\\testInput.txt");
//
//        Person person1 = persons[0];
//        Person person2 = persons[1];
//        assertEquals(1, Algorithm.comparePersons(person1, person2));
//
//        person1 = persons[2];
//        person2 = persons[3];
//        assertEquals(1, Algorithm.comparePersons(person1, person2));
//
//        person1 = persons[3];
//        person2 = persons[3];
//
//        Person finalPerson = person2;
//        Person finalPerson1 = person1;
//        Throwable exception = assertThrows(AssertionError.class, () -> Algorithm.comparePersons(finalPerson1, finalPerson));
//        assertEquals(exception.getMessage(), "Cannot compare persons with the same id. Id of a person: " + person1.getId());
//    }
//}