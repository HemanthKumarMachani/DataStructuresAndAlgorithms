package org.basicproblems.recursion;

public class PalindromeRec {
    public static void main(String[] args) {
        String strT = "ABBcBBA";
        String strF = "AllG";
        System.out.println("isPalindrome: " + isPalindromeRec(strT));
    }

    public static boolean isPalindromeRec(String s) {
        if (s.length() <= 1) return true;
        return isPalindromeHelper(0, s.length() - 1, s);
    }

    public static boolean isPalindromeHelper(int left, int right, String s) {
        if (left >= s.length() / 2) return true; //base condition
        if (s.charAt(left) != s.charAt(right)) return false; //check
        return isPalindromeHelper(left + 1, right - 1, s); //recursive call
    }
}
