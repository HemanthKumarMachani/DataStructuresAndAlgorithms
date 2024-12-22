package org.basicproblems.arrays;

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
        List<Integer> smallInput = Arrays.asList(1,2,3,4);
        List<Integer> resultListKTimes = reverseKTimes(list,8);
        System.out.println(resultListKTimes);
        System.out.println("Reversing K times O(N) approach: ");
        List<Integer> inputList = Arrays.asList(13,14,15,16,17,18);
        List<Integer> ouputList = reverseArrayKTimesON(inputList,2 );
        System.out.println("outputLIst of O(N) approach: "+ouputList);
    }

    //Reversing the entire array
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

    //Reversing in given range
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
    /*
Array Rotation:
Problem Description

Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.


Problem Constraints

1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109


Input Format

The first argument given is the integer array A.
The second argument given is the integer B.


Output Format

Return the array A after rotating it B times to the right


Example Input

Input 1:

A = [1, 2, 3, 4]
B = 2
Input 2:

A = [2, 5, 6]
B = 1


Example Output

Output 1:

[3, 4, 1, 2]
Output 2:

[6, 2, 5]


Example Explanation

Explanation 1:

Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
Explanation 2:

Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
     */
    //Brute force approach
public static List<Integer> reverseKTimes(List<Integer> A, int k) {
    int end = A.size() - 1;
    int n = k%end;
    for(int i=0; i<n; i++){ //rotating only remainder number of times, instead of K times.
        int temp = A.get(end);
        for(int j = end; j>=1; j--){
            A.set(j,A.get(j-1));
        }
        A.set(0,temp);
    }
    return A;
}

//reversing K times optimized approach O(N)
public static List<Integer> reverseArrayKTimesON(List<Integer> A, int k) {
    int n = A.size() - 1;
    k = k%n;
    reversingInRange(A, 0, n);
    reversingInRange(A,0,k-1);
    reversingInRange(A,k,n-1);
    return A;
}
}


