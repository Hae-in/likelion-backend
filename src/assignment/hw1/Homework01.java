package assignment.hw1;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        // 사용자로부터 정수를 입력받아 짝수인지 홀수인지 판별하는 프로그램을 작성하세요.
        System.out.println("정수를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num % 2 == 0) {
            System.out.println("입력한 정수는 짝수 입니다.");
        } else {
            System.out.println("입력한 정수는 홀수 입니다.");
        }
    }
}
