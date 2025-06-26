package dsa.arrays.medium;

public class MaxSubArraySum {
    public static void main(String[] args) {
        //arr = [-2,1,-3,4,-1,2,1,-5,4] 
        int [] input1 = {-2,1,-3,4,-1,2,1,-5,4};
        int [] input2 ={4};
        int [] input3 =  {-4,-1,-9,-11,-2};
        int [] input4 = {3,21,1,5,0,0,5};
        int [] input5 = {-7};
        int [] input6 = {};
        int [] input7 = {0,0,0,0,0};
        System.out.println("maxSumBFInput1: "+ maxSubArraySumBF(input1));
        System.out.println("maxSumBFInput2: "+ maxSubArraySumBF(input2));
        System.out.println("maxSumBFInput3: "+ maxSubArraySumBF(input3));
        System.out.println("maxSumBFInput4: "+ maxSubArraySumBF(input4));
        System.out.println("maxSumBFInput5: "+ maxSubArraySumBF(input5));
        System.out.println("maxSumBFInput6: "+ maxSubArraySumBF(input6));
        System.out.println("maxSumBFInput7: "+ maxSubArraySumBF(input7));
        System.out.println("Optimized version results:");
        System.out.println("maxSumBFInput1: "+ maxSubArraySumKadanesAlgo(input1));
        System.out.println("maxSumBFInput2: "+ maxSubArraySumKadanesAlgo(input2));
        System.out.println("maxSumBFInput3: "+ maxSubArraySumKadanesAlgo(input3));
        System.out.println("maxSumBFInput4: "+ maxSubArraySumKadanesAlgo(input4));
        System.out.println("maxSumBFInput5: "+ maxSubArraySumKadanesAlgo(input5));
        System.out.println("maxSumBFInput6: "+ maxSubArraySumKadanesAlgo(input6));
        System.out.println("maxSumBFInput7: "+ maxSubArraySumKadanesAlgo(input7));

    }
    //Brute force approach TC: O(N^2) SC: O(1)
    public static int maxSubArraySumBF(int [] input){
        if(input == null || input.length == 0) return 0;
        int maxSum =Integer.MIN_VALUE , n = input.length;
        for(int outer =0; outer< n; outer++){
            int sum = 0;
            for(int inner = outer; inner<n; inner++){
                sum += input[inner];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    //Kadane's Algorithm optimized approach TC: O(N), SC: O(1)
    public static int maxSubArraySumKadanesAlgo(int [] input){
        if(input == null || input.length ==0) return 0;
        int maxSum = Integer.MIN_VALUE, iteratingSum =0;
        for(int index =0; index < input.length; index++){
            iteratingSum += input[index];
            if(iteratingSum>maxSum) maxSum = iteratingSum;
            if(iteratingSum<0) iteratingSum =0;
        }
        return maxSum;
    }
    
}
