package day07.interface1;

public class PhotoTest {
    public static void main(String[] args) {
        // 추상 클래스도 타입으로 사용 가능
        // 인터페이스도 타입으로 사용 가능

        Drawable d = new Photo("a.png", 600, 400);

        // Drawable이 제공하는것까지 사용 가능
        d.draw();
        d.erase();

        // Drawable d 타입을 이렇게 사용하게 할 때 장점은?

    }
}
