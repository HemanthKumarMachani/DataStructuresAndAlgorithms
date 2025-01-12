package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Q. Subarray with given sum and length

Problem Description

Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 104

1 <= B <= N

1 <= C <= 109



Input Format

First argument A is an array of integers.

The remaining arguments B and C are integers



Output Format

Return 1 if such a subarray exist and 0 otherwise


Example Input

Input 1:


A = [4, 3, 2, 6, 1]
B = 3
C = 11
Input 2:

A = [4, 2, 2, 5, 1]
B = 4
C = 6




Example Output

Output 1:
1
Output 2:

0


Example Explanation

Explanation 1:


The subarray [3, 2, 6] is of length 3 and sum 11.


Explanation 2:


There are no such subarray.


 */
public class NumOfSubArrays {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 12, 8, -11, 5);
        int result = solve(list,3,21);
        System.out.println("result: "+result);
        int res = solve(list,2,15);
        System.out.println("res: "+res);
    }
    public static int solve(List<Integer> A, int B, int C) {
        int n = A.size();
        int start = 0;  // Left pointer
        int end = 0;    // Right pointer
        int currentSum = 0;  // Sum of the current subarray

        while (end < n) {
            // Expand the subarray to the right
            currentSum += A.get(end);

            // Check if the subarray length is greater than B
            if (end - start + 1 > B) {
                // Shrink the subarray from the left
                currentSum -= A.get(start);
                start++;
            }

            // Check if the sum is equal to C and the subarray length is B
            if (currentSum == C && end - start + 1 == B) {
                return 1;  // Subarray found
            }

            // Move the right pointer to the next element
            end++;
        }

        return 0;  // No subarray found
    }
}
