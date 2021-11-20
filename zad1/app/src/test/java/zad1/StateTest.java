//package zad1;
//
//import fileReader.FileReader;
//import person.Person;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import java.util.HashMap;
//
//public class StateTest {
//    @Test
//    public void State(){
//        HashMap<Person, Person> testConnections = new HashMap<Person, Person>();
//        Person[] persons = FileReader.readPersons(System.getProperty("user.dir") + "\\src\\test\\java\\zad1\\testInput.txt");
//
//        //temporary solution, can do better
//        if(persons.length%2 ==0){
//            for(int i=0; i< persons.length-1; i+=2){
//                testConnections.put(persons[i], persons[i+1]);
//            }
//        }
//        else{
//            for(int i=0; i< persons.length-2; i+=2){
//                testConnections.put(persons[i], persons[i+1]);
//            }
//            testConnections.put(persons[persons.length-1], null);
//        }
//
//        State state = new State(testConnections);
//        assertEquals(5, state.getStateValue());
//    }
//}
