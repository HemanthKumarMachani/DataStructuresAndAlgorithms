package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumOfSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] input = {1, 4, 7, 12, 3, 8, 9, 1, 2, 12};
        int k = 1;
        int result = maxSubArray(k, input);
        System.out.println("result: " + result);

        List<Integer> subArrayResult = maxSubArrayOfGivenLength(input, k);
        System.out.println("subArrayResult: " + subArrayResult);
    }

    public static int maxSubArray(int k, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len <= k) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int index = 0; index < k; index++) {
            windowSum += nums[index];
        }
        maxSum = windowSum;
        for (int index = k; index < len; index++) {
            windowSum += nums[index] - nums[index - k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    //Return subArray with maximum sum
    public static List<Integer> maxSubArrayOfGivenLength(int[] input, int range) {
        if (input == null || input.length == 0) return Collections.emptyList();
        int len = input.length;
        List<Integer> subArray = new ArrayList<>();
        if (len <= range) {
            int sum = 0;
            for (int num : input) {
                sum += num;
                subArray.add(num);
            }
            return subArray;
        }
// window sum
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        int left = 0, right = range-1;
        for (int index = 0; index < range; index++) {
            windowSum += input[index];
        }
//moving the window till length of the array
        maxSum = windowSum;
        for (int index = range; index < len; index++) {
            windowSum += input[index] - input[index - range];
            if (windowSum > maxSum) {
                maxSum = windowSum;
                left = index - range;
                right = index;
            }
        }
        System.out.println("maxSum inside maxSubArray method: " + maxSum);
        for(int index = left; index < right; index++) {
            subArray.add(input[index]);
        }
        return subArray;
    }

}
