package org.basicproblems.arrays;

import java.util.Arrays;
import java.util.List;

public class ReversingArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultList = reversingArray(list);
        System.out.println(resultList);
        System.out.println("Reversing in range");
        List<Integer> resultList2 = reversingInRange(list, 1, 4);
        System.out.println(resultList2);
    }

    //Reversing the entire array
    public static List<Integer> reversingArray(List<Integer> A) {
        int start = 0;
        int end = A.size() - 1;
        while (start < end) {
            int temp = A.get(start);
            A.set(start, A.get(end));
            A.set(end, temp);
            start++;
            end--;
        }
        return A;
    }

    //Reversing in given range
    public static List<Integer> reversingInRange(List<Integer> A, int start, int end) {
        if (start < 0 || end < 0) return A;
        while (start < end) {
            int temp = A.get(start);
            A.set(start, A.get(end));
            A.set(end, temp);
            start++;
            end--;
        }
        return A;
    }
}


