package day03;

public class SumExam {
    public static void main(String[] args) {
        // while문을 사용하여 1부터 100까지의 합을 구하세요.
        int i = 1, sum = 0;

        while (i <= 100) {
            sum = sum + i;
            i++;
        }

        System.out.println(sum);
    }
}
