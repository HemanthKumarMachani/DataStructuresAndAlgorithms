package dsa.sortingAlgorithms;

import java.util.Arrays;

/*
Problem Statement: Given an array of N integers, write a program to implement the Selection sorting algorithm.

Examples:
Example 1:
Input: N = 6, array[] = {13,46,24,52,20,9}
Output: 9,13,20,24,46,52
Explanation: After sorting the array is: 9, 13, 20, 24, 46, 52

Example 2:
Input: N=5, array[] = {5,4,3,2,1}
Output: 1,2,3,4,5
Explanation: After sorting the array is: 1, 2, 3, 4, 5
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] sampleInput1 = {13, 46, 24, 52, 20, 9};
        int[] sampleInput2 = {5, 4, 3, 2, 1};
        int[] resultSampleInput1 = selectionSortBf(sampleInput1);
        System.out.println("Result of sample input 1: " + Arrays.toString(resultSampleInput1));
        int[] resultSampleInput2 = selectionSortBf(sampleInput2);
        System.out.println("Result of sample input 2: " + Arrays.toString(resultSampleInput2));
        int[] input = {4, 8, 1, 3, 19, 12, 5, 9, 21, 7};
        int[] input2 = {9, 7, 5, 3, 1};
        int[] bruteForceResult = selectionSortBf(input);
        System.out.println(Arrays.toString(bruteForceResult));
        int[] twoPointerResult = selectionSortBf(input2);
        System.out.println(Arrays.toString(twoPointerResult));
        int[] input3 = {10, 4, 9, 2, 6, 1};
        int[] result = selectionSortBf(input3);
        System.out.println(Arrays.toString(result));
    }

    //Selection sort on the given input array
    //Brute force
    //{13,46,24,52,20,9}
    public static int[] selectionSortBf(int[] input) {
        if (input == null || input.length < 2) return input;
        for (int index = 0; index < input.length; index++) {
            int minIndex = index;
            for (int cursor = index + 1; cursor < input.length; cursor++) {
                if (input[cursor] < input[minIndex]) {
                    minIndex = cursor;
                }
            }
            int temp = input[index];
            input[index] = input[minIndex];
            input[minIndex] = temp;
        }
        return input;
    }
}
