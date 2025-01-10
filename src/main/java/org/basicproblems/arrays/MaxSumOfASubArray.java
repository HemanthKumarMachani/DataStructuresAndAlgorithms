package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Q. Maximum Subarray Easy
Problem Description

You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.

Problem Constraints

1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106

Input Format

The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.

Output Format

Return a single integer which denotes the maximum sum.

Example Input

Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:

A = 3
B = 1
C = [2, 2, 2]

Example Output

Output 1:
12
Output 2:

0

Example Explanation

Explanation 1:
We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
Explanation 2:

All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0.
 */

public class MaxSumOfASubArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, -2, 8);
        int resultUsingCarry = maxSumOfSubArrayUsingCarryForward(list);
        System.out.println("resultUsingCarry: " + resultUsingCarry);
        int resultUsingPrefixSum = maxSumOfSubArrayUsingPrefixSum(list);
        System.out.println("resultUsingPrefixSum: " + resultUsingPrefixSum);
    }

    //TC - O(N2) SC - O(N)
    public static int maxSumOfSubArrayUsingCarryForward(List<Integer> input) {
        if (input.isEmpty()) return 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            for (int j = i; j < input.size(); j++) {
                sum += input.get(j);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int maxSumOfSubArrayUsingPrefixSum(List<Integer> input) {
        if (input.isEmpty()) return 0;
        int maxSum = Integer.MIN_VALUE;
        List<Integer> prefixSum = prefixSum(input);
        for (int i = 0; i < prefixSum.size(); i++) {
            int sum = 0;
            for (int j = i; j < prefixSum.size(); j++) {
                if (i == 0) sum = prefixSum.get(j);
                else sum = prefixSum.get(j) - prefixSum.get(i - 1);
                maxSum = Math.max(maxSum, sum);
            }
            //maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    //prefixSum of a list
    public static List<Integer> prefixSum(List<Integer> input) {
        if (input.isEmpty()) return input;
        List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(input.getFirst());
        for (int i = 1; i < input.size(); i++) {
            prefixSum.add(input.get(i) + prefixSum.get(i - 1));
        }
        return prefixSum;
    }
}
