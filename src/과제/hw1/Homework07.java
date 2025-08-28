package 과제.hw1;

import java.util.Scanner;

public class Homework07 {
    public static void main(String[] args) {
        // 문자열 배열에 `"사과", "바나나", "딸기", "포도"`를 저장하고,
        // 사용자로부터 과일 이름을 입력받아 배열 안에 존재하는지 찾는 프로그램을 작성하세요.

        String[] fruits = {"사과", "바나나", "딸기", "포도"};

        System.out.println("과일 이름을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        boolean isContain = false;

        for (String fruit : fruits) {
            if (input.equals(fruit)) {
                System.out.println(fruit + " 포함");
                isContain = true;
                break;
            }
        }
        if (!isContain) {
            System.out.println("포함하지 않음");
        }
    }
}
