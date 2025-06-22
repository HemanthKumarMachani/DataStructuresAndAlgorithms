package dsa.arrays.medium;

public class MaxSubArraySum {
    public static void main(String[] args) {
        //arr = [-2,1,-3,4,-1,2,1,-5,4] 
        int [] input1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maxSumBFInput1: "+ maxSubArraySumBF(input1));
    }
    public static int maxSubArraySumBF(int [] input){
        if(input == null || input.length == 0) return 0;
        int maxSum =0 , n = input.length;
        for(int outer =0; outer< n; outer++){
            int sum = 0;
            for(int inner = outer; inner<n; inner++){
                sum += input[inner];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
