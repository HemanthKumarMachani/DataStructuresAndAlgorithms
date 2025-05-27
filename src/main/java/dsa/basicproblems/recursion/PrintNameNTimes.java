package dsa.basicproblems.recursion;

public class PrintNameNTimes {
    public static void main(String[] args) {
        printNameNTimes("Hemanth", 3,1);
    }
    public static void printNameNTimes(String name, int times, int i) {
        if(i>times) return;
        System.out.println(i+" : "+name);
        printNameNTimes(name, times, i+1);
    }
}
