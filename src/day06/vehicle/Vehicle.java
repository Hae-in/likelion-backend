package day06.vehicle;

// 부모 클래스(슈퍼 클래스) - 공통 속성과 기능을 정의
public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println(brand + " " + model + " 의 시동을 겁니다.");
    }

    public void stop() {
        System.out.println(brand + " " + model + "의 시동을 끕니다.");
    }

    public void displayInfo() {
        System.out.println("==================");
        System.out.println("브랜드: " + brand);
        System.out.println("모델: " + model);
        System.out.println("연식: " + year);
    }
}
