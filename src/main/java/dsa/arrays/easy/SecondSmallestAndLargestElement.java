package dsa.arrays.easy;

import java.util.Arrays;

public class SecondSmallestAndLargestElement {
    public static void main(String[] args) {
        int[] input = {4, 1, 5, 6, 21, 9, 18, 3, 22, 1};
        int[] input2 = {1};
        int[] input3 = {1, 2, 3, 4, 5, 5, 5, 5, 5, 7};
        int[] input4 = {1, 1, 1, 1};

        System.out.println("Second Smallest and Largest input1: " + Arrays.toString(secondSmallestAndLargest(input)));
        System.out.println("input2: " + Arrays.toString(secondSmallestAndLargest(input2)));
        System.out.println("input3: " + Arrays.toString(secondSmallestAndLargest(input3)));
        System.out.println("input4: " + Arrays.toString(secondSmallestAndLargest(input4)));

    }

    public static int[] secondSmallestAndLargest(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] result = {-1, -1};
        if (nums.length == 1) {
            return result;
        }
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num < firstLargest && num > secondLargest) {
                secondLargest = num;

            }
            if (num < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = num;
            } else if (num > firstSmallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }
        result[0] = (secondSmallest == Integer.MAX_VALUE) ? -1 : secondSmallest;
        result[1] = (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
        return result;
    }
}
