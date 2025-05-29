package dsa.arrays.easy;
/*
Problem Statement: Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.

Note: Two consecutive equal values are considered to be sorted.

Examples
Example 1:
Input: N = 5, array[] = {1,2,3,4,5}
Output: True.
Explanation: The given array is sorted i.e Every element in the array is smaller than or equals to its next values, So the answer is True.
Example 2:
Input: N = 5, array[] = {5,4,6,7,8}
Output: False.
Explanation: The given array is Not sorted i.e Every element in the array is not smaller than or equal to its next values, So the answer is False.

Here element 5 is not smaller than or equal to its future elements.
 */
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int [] input1 = {1,2,3,4,5};
        int [] input2 = {1};
        int [] input3 = {1,2,4,3,5};
        int [] input4 = {2,1};
        int [] input5 = {-5,-99,-122};
        int [] input6 = {Integer.MIN_VALUE,4,5,7, Integer.MAX_VALUE};
        System.out.println("Input1: "+ checkIfArrayIsSorted(input1));
        System.out.println("Input2: "+ checkIfArrayIsSorted(input2));
        System.out.println("Input3: "+ checkIfArrayIsSorted(input3));
        System.out.println("Input4: "+ checkIfArrayIsSorted(input4));
        System.out.println("Input5: "+ checkIfArrayIsSorted(input5));
        System.out.println("Input6: "+ checkIfArrayIsSorted(input6));
    }
    public static boolean checkIfArrayIsSorted(int[] input) {
        if(input == null || input.length == 0) {return true;}
        if(input.length == 1) {return true;}
        for(int i = 1; i < input.length; i++) {
            if(input[i] < input[i-1]) {return false;}
        }
        return true;
    }
}
