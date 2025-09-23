package day03;

public class OddExam {
    public static void main(String[] args) {
        // while문과 continue를 사용하여 1~20 사이의 홀수만 출력하세요.
        int i = 1;

        while (i <= 20) {
            if (i % 2 == 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
