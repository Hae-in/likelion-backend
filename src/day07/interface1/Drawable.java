package day07.interface1;

// 추상클래스 : 클래스, 미완성 메서드를 가질 수 있는 클래스
// 인터페이스 : 껍데기만 갖는다, 구현체가 없는것이 기본
public interface Drawable {
    void draw(); // 추상 메서드, 구현부가 없음

    void erase();
}
