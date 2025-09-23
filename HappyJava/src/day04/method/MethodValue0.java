package day04.method;

public class MethodValue0 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = num1; // 값을 복사해서 대입
        num2 = 10;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }
}
