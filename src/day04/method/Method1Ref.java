package day04.method;

public class Method1Ref {
    public static void main(String[] args) {
        int sum1 = add(10, 20);
        int sum2 = add(20, 30);
    }

    // add 메서드
    public static int add(int a, int b) {
        int sum = a + b;
        System.out.println("sum = " + sum);

        return sum;
    }
}
