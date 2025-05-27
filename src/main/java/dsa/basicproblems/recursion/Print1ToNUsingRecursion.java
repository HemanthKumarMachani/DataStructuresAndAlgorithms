package dsa.basicproblems.recursion;

public class Print1ToNUsingRecursion {
    public static void main(String[] args) {
        print1ToN(5);
    }
    public static void print1ToN(int n) {
        if (n==0) return;
        System.out.print(n+" ");
        print1ToN(n-1);

        System.out.print(n +" ");
    }
}
