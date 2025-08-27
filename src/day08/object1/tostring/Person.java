package day08.object1.tostring;

// Object 클래스란?
//  - 모든 클래스의 최상위 부모 클래스이며,
//  - 모든 클래스는 명시적으로 extends를 하지 않아도 자동으로 Object 클래스를 상속 받는다.
//  - 모든 객체가 공통으로 가져야 할 기본 메소드 제공
//  - 다형성의 기반 (모든 객체는 Object 타입으로 참조 가능)
//  - 컬렉션 프레임워크 기반


// toString() 메소드 : 객체의 문자열 표현을 반환
public class Person {
    private String name;
    private int age;

    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString() 오버라이딩
    // 어떻게 보여줄건지의 요구사항에 따라 수정 가능!!
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
