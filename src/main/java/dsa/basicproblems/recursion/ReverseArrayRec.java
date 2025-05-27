package dsa.basicproblems.recursion;

import java.util.Arrays;

public class ReverseArrayRec {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        System.out.println("reverse:" + Arrays.toString(reverseArray(input)));
    }

    public static int[] reverseArray(int[] arr) {
        if (arr.length <= 1) return arr;
        return reverseArrayHelper(0, arr.length - 1, arr);
    }

    public static int[] reverseArrayHelper(int left, int right, int[] arr) {
        //base condition
        if (left >= (arr.length - 1) / 2) return arr;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        return reverseArrayHelper(left + 1, right - 1, arr);
    }
}
