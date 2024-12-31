package org.basicproblems.arrays;

import java.util.Arrays;
import java.util.List;

public class SubArrays {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        printSubArrays(list);
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
}
