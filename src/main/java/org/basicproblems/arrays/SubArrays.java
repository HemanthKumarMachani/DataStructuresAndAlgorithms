package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrays {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> input = Arrays.asList(1,2,3,4,5,6,7,8,9,10,10,9,8,7,6,5,4,3,2,1);
        System.out.println("Printing sub arrays: ");
        printSubArrays(list);
        System.out.println("Returning sub arrays in range: ");
        List<Integer> subArrayInRange = subArrayInRange(input,9,13);
        System.out.println("printing sub arrays in range: " + subArrayInRange);
    }

    public static List<Integer> printSubArrays(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(input.get(k));
                }
                System.out.println();
            }
        }
        return input;
    }
    public static List<Integer> subArrayInRange(List<Integer> input, int start, int end) {
        List<Integer> result = new ArrayList<>();
        if(start == end){
            result.add(input.get(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            result.add(input.get(i));
        }
        return result;
    }
}
