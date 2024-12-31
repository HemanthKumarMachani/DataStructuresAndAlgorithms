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
}
