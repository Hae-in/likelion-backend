package day06.extends1.ex3;

public class ElectricCar extends Car {
    ElectricCar() {
        System.out.println("ElectricCar 생성자 호출");
    }

    public void charge() {
        System.out.println("충전합니다.");
    }
}
