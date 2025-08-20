package day03;

public class DoWhileExam {
    public static void main(String[] args) {
        int i = 10;
        do {
            // 무조건 한번은 실행
            System.out.println(i);
        } while (i++ < 5);
    }
}
