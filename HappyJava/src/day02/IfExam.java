package day02;

public class IfExam {
    public static void main(String[] args) {
        int i = 0;
        i += 5;
        System.out.println("i = " + i); // i 의 값이 10 보다 클때만 출력하고 싶다.

        if (i > 10) {
            System.out.println(i); // i 의 값이 10 보다 클때만 출력하고 싶다.
        }
    }
}
