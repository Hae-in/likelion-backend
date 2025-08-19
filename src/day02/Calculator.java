package day02;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nun1 = ");
        int num1 = sc.nextInt();

        System.out.println("연산자 = ");
        char op = sc.next().charAt(0);

        System.out.println("num2 = ");
        int num2 = sc.nextInt();

        double result = 0;

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = (double) num1 / num2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

        System.out.println("result = " + result);
    }
}
