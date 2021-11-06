package Algorithm;


import java.util.HashSet;
import java.util.Iterator;

public class Algorithm {

    private static int CONNECTION_VALUE = 1;

    int compareAttr(HashSet<String> attr1, HashSet<String> attr2){
        int value = 0;
        for (String attr: attr1) {
            if(attr2.contains(attr)) value += CONNECTION_VALUE;
        }
        return value;
    }
}
