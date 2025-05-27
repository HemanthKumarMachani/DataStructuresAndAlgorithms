package dsa.basicproblems.recursion;

public class SumOfFirstNNumbers {
    public static void main(String[] args) {
        System.out.println(sumOfFirstNNumbersRec(5));
    }
    public static int sumOfFirstNNumbersRec(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return n + sumOfFirstNNumbersRec(n-1);
    }
}
