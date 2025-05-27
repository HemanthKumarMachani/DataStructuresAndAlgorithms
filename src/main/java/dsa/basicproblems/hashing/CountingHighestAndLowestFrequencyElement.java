package dsa.basicproblems.hashing;

import java.util.*;

public class CountingHighestAndLowestFrequencyElement {
    //given string, exclude spaces
    public static void main(String[] args) {
        String input = "Today is going to be a productive day";
        Map<Character, Integer> resultMap = countingHighestAndLowestFrequency(input);
        System.out.println(resultMap);
    }

    public static Map<Character, Integer> countingHighestAndLowestFrequency(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        //finding frequency
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }
        //finding min and max
        //updating to the most recent occurrence, when found both of equal frequency
        char max_key = ' ';
        int max_count = Integer.MIN_VALUE;
        char min_key = ' ';
        int min_count = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(value >= max_count) {
                max_count = value;
                max_key = key;
            }
            if(value <= min_count) {
                min_count = value;
                min_key = key;
            }
        }
        countMap.put(max_key, max_count);
        countMap.put(min_key, min_count);
        return countMap;
    }

}
