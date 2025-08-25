package day04.oop;

public class Pen {
    // 속성 (값, 필드)
    String 색깔;
    int 굵기;

    // 생성자 - 클래스에 생성자가 하나도 정의되지 않으면
    // 컴파일러가 자동으로 생성자를 만듦.
    // 생성자를 하나라도 정의하면 컴파일러는 생성자를 만들지 않음.
    // 객체가 생성될때 객체를 초기화하는 일을 담당함.
    public Pen() {
        System.out.println("Pen() 생성자 실행!!!");
    }

    // 행위 (기능, 메서드)
    public void 쓰다(String msg) {
        System.out.println(msg);
    }
}
