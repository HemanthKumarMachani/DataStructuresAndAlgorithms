package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumOfASubArray {
    public static void main(String[] args) {
    List<Integer> list = Arrays.asList(4,-2,8);
    int resultUsingCarry = maxSumOfSubArrayUsingCarryForward(list);
    System.out.println("resultUsingCarry: "+resultUsingCarry);
    int resultUsingPrefixSum = maxSumOfSubArrayUsingPrefixSum(list);
    System.out.println("resultUsingPrefixSum: "+resultUsingPrefixSum);
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
