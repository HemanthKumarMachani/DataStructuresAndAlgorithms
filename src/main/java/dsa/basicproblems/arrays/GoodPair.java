/**
 * Problem Description:
 * Given an array A and an integer B, a pair (i, j) in the array is a good pair if:
 * - i != j
 * - A[i] + A[j] == B
 * Check if any good pair exists or not.
 *
 * Problem Constraints:
 * - 1 <= A.size() <= 10^4
 * - 1 <= A[i] <= 10^9
 * - 1 <= B <= 10^9
 *
 * Input Format:
 * - First argument is an integer array A.
 * - Second argument is an integer B.
 *
 * Output Format:
 * - Return 1 if a good pair exists, otherwise return 0.
 *
 * Example Input:
 * A = [1, 2, 3, 4]
 * B = 7
 *
 * Example Output:
 * 1
 *
 * Example Explanation:
 * Pair (i, j) = (3, 4) satisfies the condition.
 *
 * Approach:
 * - Use a nested loop to iterate through the array.
 * - Check each pair (i, j) where i < j to see if their sum equals B.
 * - Return 1 if a good pair is found; otherwise, return 0.
 */
package dsa.basicproblems.arrays;

import java.util.Arrays;
import java.util.List;

public class GoodPair {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 4);
        int b = 7;
        List<Integer> B = Arrays.asList(1, 2, 4);
        int result = findGoodPair(A, b);
        if (result == 1) {
            System.out.println("Found GoodPair");
        } else {
            System.out.println("Not Found GoodPair");
        }
    }

    //method to find GoodPair
    public static int findGoodPair(List<Integer> A, int B) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if ((i != j) && A.get(i) + A.get(j) == B) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
