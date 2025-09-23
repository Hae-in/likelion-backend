package day06.extends1.overriding;

public class Car {
    public void move() {
        System.out.println("차를 이동합니다.");
    }

    // 추가
    public void openDoor() {
        System.out.println("문을 엽니다.");
    }
}

// 상속 :
//  - 부모 클래스의 속성(필드)과 기능(메서드)을 자식 클래스에서 재사용
//  - extends 키워드 사용
//  - extends 대상은 하나만 선택(단일 상속)

// 오버로딩 : 이름이 같고 매개변수(파라미터)가 다른 메서드를 여러개 정의하는 것
// 오버라이딩 : 하위 클래스에서 상위 클래스의 메서드를 재정의하는 것 (상속)