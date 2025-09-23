package assignment.hw1;

public class Homework05 {
    public static void main(String[] args) {
        // 1부터 50까지 수 중에서 3의 배수이면서 5의 배수인 수만 출력하세요.
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
            }
        }
    }
}
