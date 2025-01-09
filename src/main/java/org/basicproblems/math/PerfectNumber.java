package org.basicproblems.math;

/**
 * Problem: Perfect Number
 * ---------------------------------
 * A perfect number is a positive integer that equals the sum of its proper divisors.
 * A proper divisor of a natural number is the divisor strictly less than the number itself.
 * <p>
 * Problem Constraints:
 * 1 <= A <= 10^6
 * <p>
 * Example Input: A = 28
 * Example Output: 1
 * <p>
 * Approach:
 * - Iterate divisors up to sqrt(A) to reduce complexity.
 * - Sum all proper divisors and check if it equals A.
 * <p>
 * Time Complexity: O(sqrt(A))
 * Space Complexity: O(1)
 */
public class PerfectNumber {
    public static void main(String[] args) {
        //method call
        int result = solve(29);
        if (result == 1) {
            System.out.println("Give input is a Perfect number");
        } else {
            System.out.println("Give input is not a Perfect number");
        }
    }

    public static int solve(int A) {
        int sum = 1; // Start with 1 since it's a divisor for all numbers > 1
        if (A <= 1) return 0; // Edge case
        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                sum += i;
                if (i != A / i) sum += A / i; // Avoid double counting
            }
        }
        return sum == A ? 1 : 0; // Check for perfect number
    }
}