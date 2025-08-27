package day06.extends1.ex2;

public class GasCar extends Car {
    GasCar() {
        System.out.println("GasCar 생성자 호출");
    }

    public void fillUp() {
        System.out.println("기름을 주유합니다.");
    }
}
