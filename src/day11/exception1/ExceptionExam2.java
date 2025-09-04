package day11.exception1;

public class ExceptionExam2 {
    // 예외를 처리하는 2가지 방법
    public static void 심부름() {
        // 예외를 직접 처리하는 방법
        int i = 0; // i의 값이 뭐가 들어올지 모름

        try {
            System.out.println(10 / i);
        } catch (Exception e) {
            System.out.println("다른 마트로 감");
        }
    }


    public static void 심부름2() throws Exception {
        // 예외를 심부름 시킨 쪽으로 알려줌.
        int i = 0;
        System.out.println(10 / i);
    }

    public static void main(String[] args) throws Exception {
        심부름();
        심부름2();
    }
}
