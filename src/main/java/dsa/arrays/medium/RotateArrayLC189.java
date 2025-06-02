package dsa.arrays.medium;

import java.util.Arrays;

/*
189. Rotate Array
Solved
Medium
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */
public class RotateArrayLC189 {

    public static void main(String[] args) {
        int [] input = {1,2,3,4,5,6,7};
        rotate(input, 10);
    }
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        int n = nums.length;
        int rotations = k%n;
        System.out.println("rotations: " + rotations);
        reverse(nums, 0, n-1); //[7,6,5,4,3,2,1]
        reverse(nums,0,rotations-1); //[5,6,7,4,3,2,1]
        reverse(nums,rotations,n-1); //[5,6,7,1,2,3,4]
        System.out.println("Rotated Array: "+Arrays.toString(nums));
    }
    public static void reverse(int[] nums, int start, int end) {
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
