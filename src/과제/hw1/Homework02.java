package 과제.hw1;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        // 세 개의 정수를 입력받아 그 중 가장 큰 수를 출력하세요.
        System.out.println("정수 3개를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];
        int max = 0;
        for(int i = 0; i < 3; i++ ) {
            num[i] = sc.nextInt();
            if(num[i] > max) {
                max = num[i];
            }
        }
//        System.out.println(Arrays.toString(num));
        System.out.println("가장 큰 수 : " + max);
    }
}
