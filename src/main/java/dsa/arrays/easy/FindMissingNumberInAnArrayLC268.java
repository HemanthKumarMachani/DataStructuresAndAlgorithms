package dsa.arrays.easy;

/*
268. Missing Number
Solved
Easy

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:

Input: nums = [3,0,1]

Output: 2

Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8

Explanation:

n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class FindMissingNumberInAnArrayLC268 {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 0};
        int[] input2 = {3, 0, 1};
        int[] input3 = {1};
        int[] input4 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] input5 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] input6 = {};
        System.out.println("input1: " + findMissingNumber(input1));
        System.out.println("input2: " + findMissingNumber(input2));
        System.out.println("input3: " + findMissingNumber(input3));
        System.out.println("input4: " + findMissingNumber(input4));
        System.out.println("input5: " + findMissingNumber(input5));
        System.out.println("input6: " + findMissingNumber(input6));
        System.out.println();
        System.out.println("Space Optimized Solution: ");
        System.out.println("input1: " + findMissingNumberSpaceOptimized(input1));
        System.out.println("input2: " + findMissingNumberSpaceOptimized(input2));
        System.out.println("input3: " + findMissingNumberSpaceOptimized(input3));
        System.out.println("input4: " + findMissingNumberSpaceOptimized(input4));
        System.out.println("input5: " + findMissingNumberSpaceOptimized(input5));
        System.out.println("input6: " + findMissingNumberSpaceOptimized(input6));
        int[] input = {2, 5, 12, 4, 8, 19};
        int target = 19;
        System.out.println(findTargetNumber(input, 19));
        System.out.println(findTargetNumber(input, 1));
    }

    //TC: O(N), SC: O(N)
    public static int findMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int[] frequency = new int[n + 1];
        for (int num : nums) {
            frequency[num]++;
        }
        for (int index = 0; index <= n; index++) {
            if (frequency[index] == 0) return index;
        }
        return -1;
    }

    //Follow up question to optimize SC O(1)
    public static int findMissingNumberSpaceOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = nums.length;
        for (int index = 0; index < nums.length; index++) {
            res ^= index ^ nums[index];
        }
        return res;
        /*
        int res =0, index =0;
        for(index =0; index< nums.length; index++){
            res ^= index ^ nums[index];
        }
        return res ^ index;
         */
    }

    public static int findTargetNumber(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target || nums[right] == target) {
                return (nums[left] == target) ? left + 1 : right;
            }
            left++;
            right--;
        }
        return -1;
    }
}
