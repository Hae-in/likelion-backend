package day08.object;

import java.util.Objects;

public class MyClass {
    String name;
    int value;

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        // 상속!!
        // 아무것도 정의 하지 않았음에도 불구하고..
        // Object 클래스가 가진 모든것을 사용할 수 있다는것!!!
        // myClass.

        myClass.name = "김금삐";
        System.out.println(myClass); // 나는 name 입니다.
        System.out.println(myClass.toString()); // 나는 name 입니다.
        // toString 주석처리 하면 -> day08.object.MyClass@27716f4 출력

        MyClass myClass2 = new MyClass();
        myClass2.name = "김금삐";

        // myClass 와 myClass2는 같은 객체일까요? 다른 객체일까요?

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(name, myClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String toString() {
        return "나는 " + name + " 입니다.";
    }
}
