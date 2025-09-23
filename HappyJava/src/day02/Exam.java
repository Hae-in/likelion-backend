package day02;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        System.out.println(args[0]); // String array로 만듦
        System.out.println(args[1]);

        // modify run configuration

        // 기본 타입을 객체로 바꿔주는 8개의 객체들은 형변환 하는데도 사용 됨.
        int i = Integer.parseInt(args[0]); // String → int
        int j = Integer.parseInt(args[1]); // String → int

        System.out.println("i + j = " + i + j);

        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        int a = sc.nextInt(); // 입력 받아서 int로 형변환, 그냥 next로 받으면 문자열로 받음
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.println("a + b = " + (a + b));
    }
}
