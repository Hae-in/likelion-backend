package day08.inner;

// 사용 예제
public class InnerClassTest {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        // 1. 멤버 내부 클래스 생성
        // 외부 클래스와 밀접한 관계이고 외부 인스턴스 없이 사용 불가할 때
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // 2. 정적 내부 클래스 생성
        // 외부 클래스의 인스턴스와 무관하게 사용할 때
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display();

        // 3. 지역 내부 클래스
        // 특정 메소드 내에서만 사용할 때
        outer.methodWithLocalClass();

        // 4. 익명 내부 클래스
        // 일회성 구현이 필요할 때 (Java 8+ 람다 선호)
        outer.createAnonymousClass();
    }
}