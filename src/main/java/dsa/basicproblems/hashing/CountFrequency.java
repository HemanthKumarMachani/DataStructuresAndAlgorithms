package dsa.basicproblems.hashing;

import java.util.*;

public class CountFrequency {
    //this if for array of integers
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,1,5,6,0,1,4,7,2,5,0);
        countFrequencyOfEachElement(list);
    }
    public static void countFrequencyOfEachElement(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: "+entry.getKey() + " "+" Frequency: " + entry.getValue());
        }
    }
}
