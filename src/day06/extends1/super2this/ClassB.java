package day06.extends1.super2this;

public class ClassB extends ClassA {
    public ClassB(int a) {
        this(a, 0); // this 나 super 중 선택 가능, this = 내 생성자 로직 호출
        System.out.println("ClassB 생성자 a = " + a);
    }

    public ClassB(int a, int b) {
        super();
        System.out.println("Class B 생성자 a = " + a + ", b = " + b);
    }
}
