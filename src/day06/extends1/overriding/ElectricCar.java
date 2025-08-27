package day06.extends1.overriding;

public class ElectricCar extends Car {
    public void charge() {
        System.out.println("충전합니다.");
    }

    @Override
    public void move() {
        System.out.println("전기차를 이동합니다.");
    }
}
