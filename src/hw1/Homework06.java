package hw1;

import java.util.Arrays;
import java.util.Scanner;

public class Homework06 {
    public static void main(String[] args) {
        // 정수 5개를 입력받아 배열에 저장한 후, 최대값과 최소값을 출력하세요.
        System.out.println("정수 5개를 입력하세요 : ");
        int[] num = new int[5];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        int max = num[0], min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
            if (num[i] < min) {
                min = num[i];
            }
        }

        System.out.println(Arrays.toString(num));
        System.out.println("max : " + max + ", min : " + min);
    }
}
