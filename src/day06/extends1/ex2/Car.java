package day06.extends1.ex2;

public class Car {
    Car() {
        System.out.println("Car 생성자 호출");
    }

    public void move() {
        System.out.println("차를 이동합니다.");
    }
}

// 상속 :
//  - 부모 클래스의 속성(필드)과 기능(메서드)을 자식 클래스에서 재사용
//  - extends 키워드 사용
//  - extends 대상은 하나만 선택(단일 상속)
