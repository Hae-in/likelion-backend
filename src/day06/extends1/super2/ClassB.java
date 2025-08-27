package day06.extends1.super2;

public class ClassB extends ClassA {
    public ClassB(int a) {
        // 상속을 받으면 생성자의 첫줄에 super(...) 를 사용해서 부모 클래스의 생성자를 호출해야 한다.
        // 매개변수 없는 기본 생성자일 경우 생략 가능 -> 자바가 자동으로 처리
        super();
        System.out.println("ClassB 생성자 a = " + a);
    }

    public ClassB(int a, int b) {
        super();
        System.out.println("Class B 생성자 a = " + a + ", b = " + b);
    }
}
