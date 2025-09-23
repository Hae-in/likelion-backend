package day06.extends1.super1;

public class Child extends Patent {
    public String value = "child";

    @Override
    public void hello() {
//        super.hello();
        System.out.println("Child.hello");
    }

    public void call() {
        System.out.println("value = " + value); // 먼저 본인 타입에서 찾음, 없으면 부모 타입으로
        System.out.println("this value = " + this.value); // this 생략가능, 자기 자신 참조
        System.out.println("super value = " + super.value); // 부모 클래스 참조

        this.hello(); // this 생략가능
        super.hello();
    }
}
