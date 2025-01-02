package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrays {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> input = Arrays.asList(1,2,3,4,5,6,7,8,9,10,10,9,8,7,6,5,4,3,2,1);
        System.out.println("Printing sub arrays: ");
        printSubArrays(list);
        System.out.println("Returning sub arrays in range: ");
        List<Integer> subArrayInRange = subArrayInRange(input,9,13);
        System.out.println("printing sub arrays in range: " + subArrayInRange);
        List<List<Integer>> subArrays = generateAllSubArrays(input);
        System.out.println("Printing sub arrays: " + subArrays);
    }

    public static List<Integer> printSubArrays(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(input.get(k));
                }
                System.out.println();
            }
        }
        return input;
    }
    /**
     * Problem Description:
     *
     * Given an array A of length N, return the subarray from B to C.
     *
     * Problem Constraints:
     * - 1 <= N <= 10^5
     * - 1 <= A[i] <= 10^9
     * - 0 <= B <= C < N
     *
     * Input Format:
     * - The first argument is an array of integers A.
     * - The second and third arguments are integers B and C.
     *
     * Output Format:
     * - Return a subarray of A from index B to C (both inclusive).
     *
     * Example Input:
     * Input 1:
     *  A = [4, 3, 2, 6]
     *  B = 1
     *  C = 3
     * Input 2:
     *  A = [4, 2, 2]
     *  B = 0
     *  C = 1
     *
     * Example Output:
     * Output 1:
     *  [3, 2, 6]
     * Output 2:
     *  [4, 2]
     *
     * Example Explanation:
     * Explanation 1:
     *  The subarray of A from index 1 to 3 is [3, 2, 6].
     * Explanation 2:
     *  The subarray of A from index 0 to 1 is [4, 2].
     */
    public static List<Integer> subArrayInRange(List<Integer> input, int start, int end) {
        List<Integer> result = new ArrayList<>();
        if(start == end){
            result.add(input.get(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            result.add(input.get(i));
        }
        return result;
    }
/*
Q. Generate all subarrays

Problem Description

You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Note : The order of the subarrays in the resulting 2D array does not matter.

Problem Constraints

1 <= N <= 100
1 <= A[i] <= 105

Input Format

First argument A is an array of integers.

Output Format

Return a 2D array of integers in any order.

Example Input

Input 1:
A = [1, 2, 3]
Input 2:
A = [5, 2, 1, 4]

Example Output

Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]


Example Explanation

For Input 1:
All the subarrays of the array are returned. There are a total of 6 subarrays.
For Input 2:
All the subarrays of the array are returned. There are a total of 10 subarrays.
 */
    public static List<List<Integer>> generateAllSubArrays(List<Integer> input) {
        List<List<Integer>> subArrays = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            List<Integer> subArray = new ArrayList<>();
            for (int j = i; j < input.size(); j++) {
                subArray.add(input.get(j));
            }
            subArrays.add(subArray);
        }
        return subArrays;
    }
    public static int closetMinMaxSubArray(List<Integer> nums) {
        int max = nums.stream().max(Integer::compareTo).get();
        int min = nums.stream().min(Integer::compareTo).get();
        int min_index =-1;
        int max_index =-1;
        int ans=0;
        if(min==max){ return 0;}
        for (int i =nums.size()-1; i >= 0; i--) {
            if(nums.get(i)==min){
                min_index = i;
                if(max_index !=-1){
                    ans = Math.min(ans,max_index-min_index+1);
                }
            } else if (nums.get(i)==max) {
                max_index=i;
                if(min_index !=-1){
                    ans = Math.min(ans,max_index-min_index+1);
                }
            }
        }
        return ans;
    }
}
