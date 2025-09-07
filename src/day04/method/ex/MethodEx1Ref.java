package day04.method.ex;

// 평균값 리펙토링
public class MethodEx1Ref {
    public static void main(String[] args) {
        avg(1, 2, 3);
        avg(15, 25, 35);
    }

    /*public static void avg(int a, int b, int c) {
        int sum = a + b + c;
        double average = sum / 3.0;
        System.out.println("평균값: " + average);
    }*/

    public static double avg(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("평균값: " + sum / 3.0);
        return sum / 3.0;
    }
}
