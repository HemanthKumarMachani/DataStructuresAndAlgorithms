package dsa.arrays.easy;

/*
485. Max Consecutive Ones
Solved
Easy
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
 */
public class MaxConsecutiveOnesLC485 {
    public static void main(String[] args) {
        int[] input1 = {};
        int[] input2 = {1};
        int[] input3 = {0};
        int[] input4 = {1, 1, 0, 1, 1, 1};
        int[] input5 = {1, 0, 1, 1, 0, 1};
        int[] input6 = {1, 0, 1, 0, 1, 0, 1};
        int[] input7 = {1, 1, 1, 1, 1, 1, 1};
        int[] input8 = {0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("input1: " + findMaxConsecutiveOnes(input1));
        System.out.println("input2: " + findMaxConsecutiveOnes(input2));
        System.out.println("input3: " + findMaxConsecutiveOnes(input3));
        System.out.println("input4: " + findMaxConsecutiveOnes(input4));
        System.out.println("input5: " + findMaxConsecutiveOnes(input5));
        System.out.println("input6: " + findMaxConsecutiveOnes(input6));
        System.out.println("input7: " + findMaxConsecutiveOnes(input7));
        System.out.println("input8: " + findMaxConsecutiveOnes(input8));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        int maxOnes = 0;
        int currentOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                currentOnes++;
                maxOnes = Math.max(maxOnes, currentOnes);
            } else currentOnes = 0;
        }
        return maxOnes;
    }
}
