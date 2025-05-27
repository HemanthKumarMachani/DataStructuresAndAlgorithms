package dsa.sortingAlgorithms;

import java.util.Arrays;

/*
Given an array of integers called nums,sort the array in non-decreasing order using the bubble sort algorithm and return the sorted array.

A sorted array in non-decreasing order is an array where each element is greater than or equal to all preceding elements in the array.

Examples:
Input: nums = [7, 4, 1, 5, 3]

Output: [1, 3, 4, 5, 7]

Explanation: 1 <= 3 <= 4 <= 5 <= 7.

Thus the array is sorted in non-decreasing order.

Input: nums = [5, 4, 4, 1, 1]

Output: [1, 1, 4, 4, 5]

Explanation: 1 <= 1 <= 4 <= 4 <= 5.

Thus the array is sorted in non-decreasing order.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] nums = {7, 4, 1, 5, 3};
        int [] result = bubbleSort(nums);
        System.out.println("result1: " + Arrays.toString(result));
        int [] nums2 = {5, 4, 4, 1, 1};
        int [] result2 = bubbleSort(nums2);
        System.out.println("result2: " + Arrays.toString(result2));

    }
    public static int[] bubbleSort(int[] input) {
        if(input == null || input.length < 2) return input;
        int n = input.length;
        boolean swapped = false;
        for(int index = n-1; index > 0; index--) {
            for(int cursor=0; cursor<index; cursor++) {
                if(input[cursor] > input[cursor+1]) {
                    int temp = input[cursor];
                    input[cursor] = input[cursor+1];
                    input[cursor+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        return input;
    }
}
