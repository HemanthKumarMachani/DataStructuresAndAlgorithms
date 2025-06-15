package dsa.arrays.medium;

import java.util.Arrays;

/*
 
75. Sort Colors
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */
public class SortColors {
    public static void main(String[] args) {
        int [] input ={2,0,2,1,1,0};
        int [] result = sortColors(input);
        System.out.println("Result: "+ Arrays.toString(result));
    }
    public static int[] sortColors(int [] input){
        int redCount=0,whiteCount=0,blueCount=0;
        for (int num : input) {
           if(num==0) redCount++;
           else if(num==1) whiteCount++;
           else if(num==2) blueCount++; 
        }
        fillColors(input, redCount, 0, 0);
        fillColors(input, whiteCount, 1, redCount);
        fillColors(input, blueCount, 2, redCount+whiteCount);
        System.out.println("Sorted: "+ Arrays.toString(input));
        return input;
    }
    public static void fillColors(int[]input ,int count, int fill, int index){
        while(count>0 & index<input.length){
            input[index++] = fill;
            count--;
        }
    }
}
