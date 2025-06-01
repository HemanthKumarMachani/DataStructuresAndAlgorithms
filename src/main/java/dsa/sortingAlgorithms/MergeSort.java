package dsa.sortingAlgorithms;
/*
Merge sort Algorithm
Problem:  Given an array of size n, sort the array using Merge Sort.

Examples:

Example 1:
Input: N=5, arr[]={4,2,1,6,7}
Output: 1,2,4,6,7,


Example 2:
Input: N=7,arr[]={3,2,8,5,1,4,23}
Output: 1,2,3,4,5,8,23
 */

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 6, 7};
        int[] sortedResult = mergeSort(arr);
        System.out.println(Arrays.toString(sortedResult));
    }

    public static int[] mergeSort(int[] input) {
        if (input == null || input.length == 0) return input;
        int start = 0, end = input.length - 1;
        return mergeSort(input, start, end);
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start >= end) return arr;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        return merge(arr, start, mid, end);
    }

    private static int[] merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;     // left pointer
        int j = mid + 1;   // right pointer
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];
        // Copy sorted values back to original array
        for (int t = 0; t < temp.length; t++) {
            arr[start + t] = temp[t];
        }
        return arr;
    }
}
