package dsa.basicproblems.arrays;

import java.util.Arrays;
import java.util.List;

public class ReversingArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultList = reversingArray(list);
        System.out.println(resultList);

        System.out.println("Reversing in range");
        List<Integer> resultList2 = reversingInRange(list, 1, 4);
        System.out.println(resultList2);

        System.out.println("Reversing K times: ");
        List<Integer> smallInput = Arrays.asList(1, 2, 3, 4);
        List<Integer> resultListKTimes = reverseKTimes(list, 8);
        System.out.println(resultListKTimes);

        System.out.println("Reversing K times O(N) approach: ");
        List<Integer> inputList = Arrays.asList(13, 14, 15, 16, 17, 18);
        List<Integer> ouputList = reverseArrayKTimesON(inputList, 2);
        System.out.println("outputLIst of O(N) approach: " + ouputList);
    }

    /**
     * Reverses the entire list in place.
     *
     * @param A The list of integers to be reversed.
     * @return The reversed list.
     * Time Complexity: O(N), where N is the size of the list.
     */
    public static List<Integer> reversingArray(List<Integer> A) {
        int start = 0;
        int end = A.size() - 1;
        while (start < end) {
            int temp = A.get(start);
            A.set(start, A.get(end));
            A.set(end, temp);
            start++;
            end--;
        }
        return A;
    }

    /**
     * Reverses the elements in the list within a specified range.
     *
     * @param A     The list of integers to be reversed.
     * @param start The starting index of the range to reverse.
     * @param end   The ending index of the range to reverse.
     * @return The list with the specified range reversed.
     * Time Complexity: O(N), where N is the size of the specified range.
     */
    public static List<Integer> reversingInRange(List<Integer> A, int start, int end) {
        if (start < 0 || end < 0) return A;
        while (start < end) {
            int temp = A.get(start);
            A.set(start, A.get(end));
            A.set(end, temp);
            start++;
            end--;
        }
        return A;
    }

    /**
     * Rotates the list to the right by k positions using a brute force approach.
     *
     * @param A The list of integers to be rotated.
     * @param k The number of positions to rotate the list.
     * @return The rotated list.
     * Time Complexity: O(K * N), where K = k % N and N is the size of the list.
     */
    public static List<Integer> reverseKTimes(List<Integer> A, int k) {
        int end = A.size() - 1;
        int n = k % end;
        for (int i = 0; i < n; i++) { // Rotating only remainder number of times instead of K times.
            int temp = A.get(end);
            for (int j = end; j >= 1; j--) {
                A.set(j, A.get(j - 1));
            }
            A.set(0, temp);
        }
        return A;
    }

    /**
     * Rotates the list to the right by k positions using an optimized O(N) approach.
     *
     * @param A The list of integers to be rotated.
     * @param k The number of positions to rotate the list.
     * @return The rotated list.
     * Time Complexity: O(N), where N is the size of the list.
     */
    public static List<Integer> reverseArrayKTimesON(List<Integer> A, int k) {
        int n = A.size() - 1;
        k = k % n;
        reversingInRange(A, 0, n);
        reversingInRange(A, 0, k - 1);
        reversingInRange(A, k, n - 1);
        return A;
    }
}