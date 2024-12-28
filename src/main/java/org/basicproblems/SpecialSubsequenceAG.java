package org.basicproblems;

public class SpecialSubsequenceAG {
    public static void main(String[] args) {
        String input = "ABCGAG";
        int result = solve(input);
        System.out.println("Result: " + result);
    }
    /*
    You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
     */
    public static int solve(String A) {
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
