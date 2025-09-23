package day06;

// 상속

class Parent {
    int i = 10;

    public int getI() {
        return i;
    }
}

// 상속 - 부모가 가진 속성과 기능을 그대로 물려 받는것!
class Child extends Parent {
    int i = 20; // 오버라이딩
    int j = 30;

    public int getI() {
        return i;
    }
}

public class Exam01 {
    public static void main(String[] args) {

        // 1. 부모는 자식을 가리킨다.
        // 2. 필드는 타입을 따른다.
        Parent p = new Parent();
        System.out.println(p.i);

        Child c = new Child();
        System.out.println(c.i);

        Parent p2 = new Child();
        System.out.println(p2.i);

        // 3. 메소드는 오버라이드되면 무조건!!! 자식의 것이 사용됨
        System.out.println(p2.getI());
    }
}
