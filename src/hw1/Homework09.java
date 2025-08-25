package hw1;

import java.util.Random;
import java.util.Scanner;

public class Homework09 {
    public static void main(String[] args) {
        // 숫자 맞추기 게임 🎮
        // 1~100 사이의 랜덤 숫자를 하나 정합니다.
        // 사용자가 숫자를 입력하면,
        // 정답보다 크면 "더 작은 수를 입력하세요."
        // 정답보다 작으면 "더 큰 수를 입력하세요."
        // 정답을 맞히면 "정답입니다!"를 출력하고 종료합니다.

        Random rand = new Random();
        int answer = rand.nextInt(100) + 1;

        System.out.println(answer);
        System.out.println("1~100 사이의 숫자를 하나 입력하세요 : ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if(num > answer) {
                System.out.println("더 작은 수를 입력하세요.");
            } else if (num < answer) {
                System.out.println("더 큰 수를 입력하세요.");
            } else {
                System.out.println("정답입니다!");
                break;
            }
        }
    }
}
