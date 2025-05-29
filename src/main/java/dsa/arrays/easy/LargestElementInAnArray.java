package dsa.arrays.easy;
/*
Problem Statement: Given an array, we have to find the largest element in the array.

Examples

Example 1:
Input: arr[] = {2,5,1,3,0};
Output: 5
Explanation: 5 is the largest element in the array.

Example2:
Input: arr[] = {8,10,5,7,9};
Output: 10
Explanation: 10 is the largest element in the array.
 */
public class LargestElementInAnArray {
    public static void main(String[] args) {
        int [] input = {4,1,6,12,9,14};
        System.out.println("Largest Element: "+ largestElementInAnArray(input));
        System.out.println("Largest Element recursive: "+ largestElementInAnArrayRecursive(input));
    }
    public static int largestElementInAnArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    public static int largestElementInAnArrayRecursive(int[] nums) {
        int max = Integer.MIN_VALUE;
        return largestElementRecursiveHelper(nums, 0, max);
    }
    public static int largestElementRecursiveHelper(int[] nums , int index, int max) {
        if(index >= nums.length) return max;
        if(max < nums[index]) max = nums[index];
        return largestElementRecursiveHelper(nums, index+1, max);
    }
}
