package day02;

public class PrimitiveCastExam {
    public static void main(String[] args) {
        // 형변환
        // byte → short → int → long(8byte) → float(4byte) → double
        //      ↘ char ↗

        byte b = 10;
        int i = b;

        System.out.println(b);

        // 형변환이 일어날때 값의 크기는 중요하지 않다. 타입(그릇)의 크기가 중요하다.
        b = (byte) i; // 컴파일러 오류, int를 byte에 대입해서
        System.out.println(b);

        // long(정수형) → float(부동소수점) (x)
        // long의 값 중 일부는 float로 표현할 때 정밀 손실이 커지기 때문
        long lx = 9223372036854775807L; // long 최대값
        float fy = lx; // 컴파일 오류 발생
        System.out.println("fy=" + fy); // 근사치 출력됨

        long lx2 = 10000000000000000L;
        float fy2 = (float) lx2; // // 명시적 형변환
        System.out.println("fy2=" + fy2); // 근사치 출력됨

        byte b2 = (byte) 128;
        System.out.println(b2); // 오버플로우, -128


    }
}
