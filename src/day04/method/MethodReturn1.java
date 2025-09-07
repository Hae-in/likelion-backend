package day04.method;

public class MethodReturn1 {
    public static void main(String[] args) {
        boolean result = odd(3212);
        System.out.println(result);
    }

    public static boolean odd(int i) {
        if (i % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
