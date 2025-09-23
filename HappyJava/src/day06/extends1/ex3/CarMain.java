package day06.extends1.ex3;

public class CarMain {
    public static void main(String[] args) {
        // 상속과 메모리 구조
        // 객체 생성 시 ElectricCar 뿐만 아니라 상속 관계에 있는 Car까지 인스턴스 생성
        // 부모 클래스의 생성자가 먼저 호출
        // 이후에 자식 클래스의 생성자 실행
        // 내부적으로 부모 -> 자식 순서로 인스턴스 초기화 진행
        // 왜 ? 상속은 부모의 필드와 메서드를 물려받는 구조이기 때문에,
        //      부모가 갖고 있는 필드와 메서드를 사용하려면 부모 객체가 메모리에 존재해야함.
        //      자식 객체 안에 부모 객체의 구조가 포함
        ElectricCar electricCar = new ElectricCar();
        electricCar.move(); // 자식 타입에 해당 기능이 없으면 부모 타입으로 올라가서 찾음 -> 컴파일 오류
        electricCar.charge();
        electricCar.openDoor();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
        gasCar.openDoor();

        HydrogenCar hydrogenCar = new HydrogenCar();
        hydrogenCar.move();
        hydrogenCar.fillHydrogen();
        hydrogenCar.openDoor();
    }
}
