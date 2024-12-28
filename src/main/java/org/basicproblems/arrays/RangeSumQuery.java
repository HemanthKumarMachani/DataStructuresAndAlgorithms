package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumQuery {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);//,5,6,7); {1,3,6,10} //{1,1,4,4} //{1,3,3,7}
        List<Integer> resultList = prefixSumOfList(list);
        System.out.println("prefix sum of input list:" + resultList);
        List<List<Integer>> sampleQueries = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            sampleQueries.add(new ArrayList<>());
        }
        sampleQueries.get(0).add(0);
        sampleQueries.get(0).add(2);
        sampleQueries.get(1).add(1);
        sampleQueries.get(1).add(3);
        List<Integer> rangeSumQueryOutput = rangeSumQuery(list, sampleQueries);
        System.out.println("range sum query output:" + rangeSumQueryOutput);
        List<Integer> evenPrefixSum = evenPrefixSumOfList(list);
        System.out.println("even prefix sum of input list:" + evenPrefixSum);
        List<Integer> oddPrefixSum = oddPrefixSumOfList(list);
        System.out.println("odd prefix sum of input list:" + oddPrefixSum);
    }

    //Generating prefix sum array of the input array.
    //A prefix sum is noting but a cumulative sum of sequence of elements of the input list.
    //Generated using pf[i] = p[i-1] + input[i] which means current element of prefix array
    //is obtained by the sum of previous element in prefix array and current element in input array.

    /**
     * Computes the range sum for each query in the given 2D array of queries.
     * The sum of elements from index L to R is efficiently calculated using the prefix sum array:
     * - If L == 0, result = prefix[R]
     * - Otherwise, result = prefix[R] - prefix[L-1]
     *
     * @param inputList The input list of integers.
     * @param queries   A 2D list where each row represents a query [L, R].
     * @return A list of integers representing the sum for each query.
     * Time Complexity: O(N + M), where N is the size of the input list, and M is the number of queries.
     */
    public static List<Integer> prefixSumOfList(List<Integer> list) {
        List<Integer> prefList = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return prefList;
        }
        prefList.add(list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            prefList.add(prefList.get(i - 1) + list.get(i));
        }
        return prefList;
    }

    public static List<Integer> rangeSumQuery(List<Integer> inputList, List<List<Integer>> queries) {
        List<Integer> resultList = new ArrayList<>();
        if (inputList == null || inputList.isEmpty()) {
            return resultList;
        }
        List<Integer> prefList = prefixSumOfList(inputList);
        System.out.println("prefix sum output inside rangeSum: " + prefList);
        int m = queries.size();
        for (List<Integer> query : queries) {
            int left = query.get(0);
            int right = query.get(1);
            if (left == 0) resultList.add(prefList.get(right));
            else resultList.add(prefList.get(right) - prefList.get(left - 1));
        }
        return resultList;
    }

    /**
     * Computes the even-index prefix sum for the input list.
     * For each element at even indices, sums the elements cumulatively.
     *
     * @param inputList Input list of integers.
     * @return List of even-index prefix sums.
     */
    //sum of even element prefix sum
    public static List<Integer> evenPrefixSumOfList(List<Integer> inputList) {
        List<Integer> resultList = new ArrayList<>();
        if (inputList == null || inputList.isEmpty()) {
            return resultList;
        }
        resultList.add(inputList.getFirst());
        for (int i = 1; i < inputList.size(); i++) {
            if (i % 2 == 0) resultList.add(resultList.get(i - 1) + inputList.get(i));
            else resultList.add(resultList.get(i - 1));
        }
        return resultList;
    }

    /**
     * Computes the odd-index prefix sum for the input list.
     * For each element at odd indices, sums the elements cumulatively.
     *
     * @param inputList Input list of integers.
     * @return List of odd-index prefix sums.
     */
    //sum of odd elements prefix sum
    public static List<Integer> oddPrefixSumOfList(List<Integer> inputList) {
        List<Integer> resultList = new ArrayList<>();
        if (inputList == null || inputList.isEmpty()) {
            return resultList;
        }
        resultList.add(inputList.getFirst());
        for (int i = 1; i < inputList.size(); i++) {
            if (i % 2 != 0) resultList.add(resultList.get(i - 1) + inputList.get(i));
            else resultList.add(resultList.get(i - 1));
        }
        return resultList;
    }

    /**
     * Finds the count of special indices in the array.
     * A special index is an index such that removing the element at this index
     * makes the sum of even-indexed and odd-indexed elements equal.
     * <p>
     * Problem Constraints:
     * 1 <= N <= 10^5
     * -10^5 <= A[i] <= 10^5
     * Sum of all elements of A <= 10^9
     *
     * @param inputList Input list of integers.
     * @return Count of special indices.
     */
    //special index. Special Index ia an indexing after removing which sum of even-indexed elements is equal
    //to sum of odd-indexed elements // return count of special indexes
    public static int specialIndex(List<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return -1;
        }
        int count = 0;
        int n = inputList.size();
        List<Integer> evenPrefixSum = evenPrefixSumOfList(inputList);
        List<Integer> oddPrefixSum = oddPrefixSumOfList(inputList);
        for (int i = 0; i < inputList.size(); i++) {
            int evenSum = 0;
            int oddSum = 0;
            if (i == 0) {
                evenSum = oddPrefixSum.get(n - 1) - oddPrefixSum.get(i);
                oddSum = evenPrefixSum.get(n - 1) - evenPrefixSum.get(i);
            } else {
                evenSum = evenPrefixSum.get(i - 1) + (oddPrefixSum.get(n - 1) - oddPrefixSum.get(i));
                oddSum = oddPrefixSum.get(i - 1) + (evenPrefixSum.get(n - 1) - evenPrefixSum.get(i));
            }
            if (evenSum == oddSum) {
                count++;
            }
        }
        return count;
    }
}
