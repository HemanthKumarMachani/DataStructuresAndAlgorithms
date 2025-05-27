package dsa.basicproblems.math;

import java.util.Scanner;

/**
 * Problem Description:
 * You will be given an integer n. You need to return the count of prime numbers less than or equal to n.
 * <p>
 * Problem Constraints:
 * 0 <= n <= 10^3
 * <p>
 * Input Format:
 * Single input parameter n in function.
 * <p>
 * Output Format:
 * Return the count of prime numbers less than or equal to n.
 * <p>
 * Example Input:
 * Input 1: 19
 * Input 2: 1
 * <p>
 * Example Output:
 * Output 1: 8
 * Output 2: 0
 * <p>
 * Example Explanation:
 * Explanation 1: Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19.
 * Explanation 2: There are no primes <= 1.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        boolean result = isPrime(n);
        if (result) {
            System.out.println("Given number " + n + " is prime number");
        } else {
            System.out.println("Given number " + n + " is not prime number");
        }
        int countPrime = countPrime(n);
        System.out.println("Number of prime number for " + n + " is: " + countPrime);
    }

    //Method to count number of primes
    public static int countPrime(int n) {
        int count = 0;
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        for (int i = 3; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
                if (isPrime) count++;
            }
        }
        return count;
    }

    //Method to check if the given number is a prime number or not
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
