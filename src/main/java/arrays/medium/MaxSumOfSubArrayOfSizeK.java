package arrays.medium;

public class MaxSumOfSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] input = {1, 4, 7, 12, 3, 8, 9, 1, 2, 12};
        int k = 5;
        int result = maxSubArray(k, input);
        System.out.println("result: "+result);
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
}
