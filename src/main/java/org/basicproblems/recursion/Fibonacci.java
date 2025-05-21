package org.basicproblems.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        //System.out.println(fibonacciIterative(5));
        int result = fibonacciIterative(9);
        System.out.println(result);
    }
    public static int fibonacciIterative(int n) {
        if(n == 0) {
            System.out.println("0");
            return 0;
        }else {
            int secondLast = 0;
            int last = 1;
            System.out.print(secondLast + " "+ last+" ");
            for(int i = 2; i <= n; i++) {
                int current = secondLast + last;
                secondLast = last;
                last = current;
                System.out.print(current + " ");
            }
            System.out.println();
            return last;
        }
    }
}
