package dsa.basicproblems.math;

/**
 * Problem Description:
 * <p>
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Return the maximum possible profit.
 * <p>
 * Problem Constraints:
 * - 0 <= len(A) <= 7e5
 * - 1 <= A[i] <= 1e7
 * <p>
 * Input Format:
 * The first and the only argument is an array of integers, A.
 * <p>
 * Output Format:
 * Return an integer, representing the maximum possible profit.
 * <p>
 * Example Input:
 * Input 1:
 * A = [1, 2]
 * Input 2:
 * A = [1, 4, 5, 2, 4]
 * <p>
 * Example Output:
 * Output 1:
 * 1
 * Output 2:
 * 4
 * <p>
 * Example Explanation:
 * Explanation 1:
 * Buy the stock on day 0, and sell it on day 1.
 * Explanation 2:
 * Buy the stock on day 0, and sell it on day 2.
 */
public class BestTimeToBuyAndSellStocks {

    /**
     * This method calculates the maximum profit that can be obtained by completing
     * at most one transaction (buy one share and sell one later) given an array of stock prices.
     *
     * @param A An array of integers where the ith element represents the price of the stock on day i.
     * @return The maximum possible profit from one transaction. If no profit is possible, return 0.
     * <p>
     * Approach:
     * 1. Track the minimum price encountered so far while iterating through the array.
     * 2. Calculate the potential profit at each step by subtracting the minimum price from the current price.
     * 3. Update the maximum profit encountered so far.
     * <p>
     * Edge Cases:
     * - If the array is empty or has only one price, return 0 (no transaction possible).
     * - If all prices are in decreasing order, the maximum profit will be 0.
     * <p>
     * Time Complexity: O(N), where N is the length of the array (single pass).
     * Space Complexity: O(1), as only constant space is used.
     */
    public static int maxProfit(int[] A) {
        // Handle edge cases where no transaction is possible
        if (A == null || A.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE; // To track the minimum price encountered so far
        int maxProfit = 0; // To track the maximum profit encountered so far

        // Iterate through the array
        for (int price : A) {
            // Update the minimum price
            minPrice = Math.min(minPrice, price);
            // Calculate the profit for the current price
            int currentProfit = price - minPrice;
            // Update the maximum profit
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }

    /**
     * Main method for testing the solution with sample inputs.
     */
    public static void main(String[] args) {
        // Example Input 1
        int[] A1 = {1, 2};
        System.out.println("Maximum Profit (Input 1): " + maxProfit(A1)); // Output: 1

        // Example Input 2
        int[] A2 = {1, 4, 5, 2, 4};
        System.out.println("Maximum Profit (Input 2): " + maxProfit(A2)); // Output: 4
    }
}