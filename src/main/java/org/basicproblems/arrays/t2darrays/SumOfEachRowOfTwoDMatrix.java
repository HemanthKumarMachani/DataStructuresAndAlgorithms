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
        printAntiDiagonal(arrMatix);
        int[][] recMatix = {
                {1, 3, 7, 8, 4},
                {2, 0, 1, 8, 2},
                {9, 1, 3, 6, 7},
        };
        printingAllDiagonals(recMatix);
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
        System.out.println();
    }

    public static void printAntiDiagonal(int[][] matrix) {
        System.out.println("Printing anti diagonal: ");
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][n - i - 1] + " ");
        }
        System.out.println();
    }

    /*
    Printing all the diagonals of a rectangular matrix from left to right (bottom to top direction)
    {
    [1,3,7,8,4]
    [2,0,1,8,2]
    [9,1,3,6,7]
    }
     */
    public static void printingAllDiagonals(int[][] matrix) {
        System.out.println("Printing all diagonals: ");
        int n = matrix.length;
        int m = matrix[0].length;
        int i = n - 1, j = 0;
        int row = i, col = 0;
        while (col < m) {
            i = row;
            j = col;
            while (i < n && j < m) {
                System.out.print(matrix[i][j] + " ");
                i++;
                j++;
            }
            System.out.println();
            if (row > 0) row--;
            else col++;
        }
    }
}
