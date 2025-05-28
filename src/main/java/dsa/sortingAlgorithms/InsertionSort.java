package dsa.sortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] input = {3,5,1,2,17,6};
        int [] result = insertionSort(input);
        System.out.println("Result of insertion sort: "+ Arrays.toString(result));
    }

    public static int[] insertionSort(int[] input) {
        if (input == null || input.length < 2) return input;
        int n = input.length;
        for (int index = 1; index < n; index++) {
            int cursor = index;
            while (cursor > 0 && input[cursor] < input[cursor - 1]) {
                int temp = input[cursor];
                input[cursor] = input[cursor - 1];
                input[cursor - 1] = temp;
                cursor--;
            }
        }
        return input;
    }
}
