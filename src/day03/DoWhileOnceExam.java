package day03;

public class DoWhileOnceExam {
    public static void main(String[] args) {
        // do / while문에서 조건이 처음부터 false여도 1회 실행됨을 확인하는 코드를 작성하세요.
        int i = 1;
        do {
            System.out.println(i);
        } while (false);
    }
}
