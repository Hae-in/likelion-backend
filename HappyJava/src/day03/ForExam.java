package day03;

public class ForExam {
    public static void main(String[] args) {

        int i = 1;
        // 초기화; 조건식; 증감식
        for (; i <= 10; i++) {
            System.out.println(i);
        }

        // 변수의 범위 -- 언어마다 차이가 있을 수 있다.
        // 자바는 변수의 스코츠가 블럭단위
        System.out.println(i);
    }
}
