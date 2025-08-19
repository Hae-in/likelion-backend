package day02;

public class OpExam {
    public static void main(String[] args) {
        int x = 1, y = 2;

        System.out.println("\n----- 연산자 -----");
        System.out.println(x == y);
        System.out.println(x != y);
        System.out.println(x < y);
        System.out.println(x > y);
        System.out.println(x <= y);
        System.out.println(x >= y);

        System.out.println("\n----- 논리 연산자 -----");
        boolean a = true, b = false;
        System.out.println(a && b); // and
        System.out.println(a || b); // or
        System.out.println(!a); // not
        System.out.println(a ^ b); // xor

        System.out.println("\n----- 단락 평가 (Short-Circuit) -----");
        // && : 첫 번째가 false면 두 번째 평가 안 함
        // || : 첫 번째가 true면 두 번째 평가 안 함
        int e = 5, f = 8;
        System.out.println((x > y++) && (e < f++));
        System.out.println(e);
        System.out.println(f);

        System.out.println("\n----- 증감 연산자 -----");
        int i = 7;
        System.out.println("i=" + i);
        System.out.println("++i=" + ++i);
        System.out.println("i=" + i);
        System.out.println("i++=" + i++);
        System.out.println("i=" + i);
    }
}
