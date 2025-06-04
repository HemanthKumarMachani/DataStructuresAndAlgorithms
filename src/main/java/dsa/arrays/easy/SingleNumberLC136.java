package dsa.arrays.easy;
/*
136. Single Number
Solved
Easy
Hint
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumberLC136 {
    public static void main(String[] args) {
        int [] input1 ={};
        int [] input2 ={2,2,1};
        int [] input3 = {4,1,2,1,2};
        int [] input4 ={4,4,4,4,1};
        int [] input5 ={1,1,1,1,1,1};
        int [] input6 ={5,5,5};
        System.out.println("input1: "+ singleNumber(input1));
        System.out.println("input2: "+ singleNumber(input2));
        System.out.println("input3: "+ singleNumber(input3));
        System.out.println("input4: "+ singleNumber(input4));
        System.out.println("input5: "+ singleNumber(input5));
        System.out.println("input6: "+ singleNumber(input6));

    }
    //TC: O(N), SC: O(1)
    public static int singleNumber(int[] nums){
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}
