package org.basicproblems.arrays.t2darrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfEachRowOfTwoDMatrix {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(3,4,5));
        matrix.add(Arrays.asList(6,7,8));
        matrix.add(Arrays.asList(9,10,11));
        System.out.println(matrix);
        for(int i=0; i<matrix.size(); i++){
            int sum = 0;
            for(int j=0; j<matrix.get(i).size(); j++){
                sum += matrix.get(i).get(j);
            }
            System.out.print(sum+" ");
        }
        System.out.println();
        System.out.println("sumOfEachColumnOfTwoDMatrix: "+ sumOfEachColumnOfTwoDMatrix(matrix));
    }

    public static List<Integer> sumOfEachColumnOfTwoDMatrix(List<List<Integer>> matrix) {
        List<Integer> result = new ArrayList<>();
        for(int j=0; j<matrix.get(j).size(); j++){
            int sum =0;
            for(int i=0; i<matrix.get(i).size(); i++){
                sum += matrix.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }
}
