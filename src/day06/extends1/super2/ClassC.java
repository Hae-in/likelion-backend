package day06.extends1.super2;

public class ClassC extends ClassB {
    public ClassC() {
        // 상속 관계에서 부모의 생성자를 호출할 때는 `super(...)` 를 사용
        // 생성자는 하나만 호출할 수 있다.
        // 두 생성자 중에 하나를 선택하면 된다.
        // ClassB에는 기본 생성자가 없으므로 super()를 사용하거나 생략할 수 없다.
        super(10, 20);
        System.out.println("ClassC 생성자");
    }
}
