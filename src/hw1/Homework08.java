package hw1;

import java.util.Scanner;

public class Homework08 {
    public static void main(String[] args) {
        // 학생 5명의 점수를 입력받아 배열에 저장하고,
        // 전체 평균 점수, 최고 점수, 60점 이상인 학생 수 를 출력하세요.

        int[] scores = new int[5];
        int sum = 0, max = 0, count = 0;
        double avg = 0;

        System.out.println("학생 5명의 성적을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < scores.length; i++){
            scores[i] = sc.nextInt();
            sum = sum + scores[i];
            max = max < scores[i] ? scores[i] : max;
            if(scores[i] >= 60) {
                count++;
            }
        }
        avg = (double) sum / scores.length;

//        System.out.println(Arrays.toString(scores));
        System.out.println("평균 점수 = " + avg);
        System.out.println("최고 점수 = " + max);
        System.out.println("60점 이상인 학생 수 = " + count);
    }
}
