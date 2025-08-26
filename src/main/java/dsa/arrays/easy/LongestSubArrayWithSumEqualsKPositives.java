package dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumEqualsKPositives {
    public static void main(String[] args) {
        int[] input1 = {-1, 1, 1};
        int[] input2 = {2, 3, 5};
        System.out.println("input1: " + longestSubarrayEqualK(input1, 4));
        System.out.println("input2: " + longestSubarrayEqualK(input2, 5));
        int [] arr1 = {2,3,5};
        int [] arr2 = {2,3,5,1,9};
        System.out.println("arr1: " + longestSubArrayEqualsK(arr1, 5));
        System.out.println("arr2: " + longestSubArrayEqualsK(arr2, 10));

    }

    public static int longestSubArrayEqualsK(int[] input, int k) {
        if (input == null || input.length == 0) return 0;
        int left = 0, right = 0, sum = 0, maxLength = 0, n = input.length;
        while (right < n) {
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left);
                sum -= input[left++];
            }
            while (sum > k && left<=right) {
                sum -= input[left++];
            }
            if (sum < k) {
                if (right + 1 < n) {
                    sum += input[right];
                    //right++;
                }
                right++;
            }
        }
        return maxLength;
    }

    public static int longestSubarrayEqualK(int[] input, int k) {
        if (input.length == 0) return 0;
        int n = input.length;
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += input[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            int reminder = sum - k;
            if (prefixMap.containsKey(reminder)) {
                int len = i - prefixMap.get(reminder);
                maxLength = Math.max(maxLength, len);
            }
            if (!prefixMap.containsKey(sum)) {
                prefixMap.put(sum, i);
            }
        }
        return maxLength;
    }
}
