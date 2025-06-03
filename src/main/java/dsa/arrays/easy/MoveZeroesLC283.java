package dsa.arrays.easy;

import java.util.Arrays;

/*
283. Move Zeroes
Solved
Easy
Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroesLC283 {
    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        int [] nums2 = {0};
        moveZeroes(nums);
        moveZeroes(nums2);
    }
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <2) return;
        int left =0;
        for(int right =0; right < nums.length; right++) {
            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
