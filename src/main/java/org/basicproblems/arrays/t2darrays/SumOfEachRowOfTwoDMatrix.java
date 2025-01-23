package org.basicproblems.arrays.t2darrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfEachRowOfTwoDMatrix {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(3, 4, 5));
        matrix.add(Arrays.asList(6, 7, 8));
        matrix.add(Arrays.asList(9, 10, 11));
        System.out.println(matrix);
        int[][] arrMatix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(matrix);
        for (int i = 0; i < matrix.size(); i++) {
            int sum = 0;
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sum += matrix.get(i).get(j);
            }
            System.out.print(sum + " ");
        }
        System.out.println();
        System.out.println("sumOfEachColumnOfTwoDMatrix: " + sumOfEachColumnOfTwoDMatrix(matrix));
        printPrincipleDiagonal(arrMatix);
    }

    public static List<Integer> sumOfEachColumnOfTwoDMatrix(List<List<Integer>> matrix) {
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < matrix.getFirst().size(); j++) {
            int sum = 0;
            for (int i = 0; i < matrix.get(j).size(); i++) {
                sum += matrix.get(j).get(i);
            }
            result.add(sum);
        }
        return result;
    }

    public static void printPrincipleDiagonal(int[][] matrix) {
        System.out.println("Printing principle diagonal: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
    }
}
