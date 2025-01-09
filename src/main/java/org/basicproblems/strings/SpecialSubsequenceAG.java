package org.basicproblems.strings;

public class SpecialSubsequenceAG {
    public static void main(String[] args) {
        String input = "ABCGAG";
        int result = findSpecialSequence(input);
        System.out.println("Result: " + result);
    }
    /*
    You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
     */

    /**
     * This method calculates the number of special subsequences in a given string `A`.
     * A "special subsequence" is defined as a pair of characters 'A' and 'G' such that 'A'
     * appears before 'G' in the string. The result is computed modulo 10^9 + 7 to handle
     * large numbers.
     *
     * @param A The input string consisting of uppercase alphabets.
     * @return The count of all valid subsequences of type "A-G" modulo 10^9 + 7.
     * <p>
     * Approach:
     * 1. Initialize:
     * - `count`: Stores the total number of valid "A-G" subsequences.
     * - `aCount`: Keeps track of the number of 'A' characters encountered so far.
     * - `M`: Modulo value 10^9 + 7 for large number arithmetic.
     * <p>
     * 2. Iterate through the string character by character:
     * - If the character is 'A', increment `aCount` to account for its contribution to
     * potential "A-G" pairs.
     * - If the character is 'G', add the current value of `aCount` to `count`, as each
     * 'A' encountered so far can form a pair with the current 'G'.
     * <p>
     * 3. Ensure the value of `count` remains within bounds by taking modulo 10^9 + 7 after
     * each addition.
     * <p>
     * 4. Return the final value of `count` as an integer.
     * <p>
     * Time Complexity:
     * - O(N), where N is the length of the string. The method involves a single pass through
     * the string.
     * <p>
     * Space Complexity:
     * - O(1). The method uses a constant amount of extra space.
     * <p>
     * Example:
     * Input: "AAGAG"
     * Execution:
     * - 'A' → Increment `aCount` (now 1).
     * - 'A' → Increment `aCount` (now 2).
     * - 'G' → Add `aCount` (2) to `count` (now 2).
     * - 'A' → Increment `aCount` (now 3).
     * - 'G' → Add `aCount` (3) to `count` (now 5).
     * Output: 5
     * <p>
     * Notes:
     * - The method handles cases with no 'A' or no 'G' gracefully, returning 0.
     */
    public static int findSpecialSequence(String A) {
        long count = 0;
        int aCount = 0; // Count of 'A' encountered so far
        long M = 1000000007;
        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);

            if (currentChar == 'A') {
                aCount++;
            } else if (currentChar == 'G') {
                // For every 'G' encountered, add the count of 'A' encountered so far
                count = (count + aCount) % M;
            }
        }

        return (int) count;
    }
}
