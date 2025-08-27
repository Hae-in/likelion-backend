package day06.extends1.ex2;

public class CarMain {
    public static void main(String[] args) {

        // new ElectricCar()를 호출하면 ElectricCar 뿐만 아니라
        // 상속 관계에 있는 Car 까지 함께 포함해서 인스턴스 생성
        ElectricCar electricCar = new ElectricCar();

        // electricCar.charge() 를 호출하면 참조값을 확인해서 참조값.charge()를 호출
        // 그런데 상속 관계에서는 내부에 부모와 자식이 모두 존재
        // Car에서 찾을지, ElectricCar에서 찾을지 선택해야하는데
        // 이때 호출하는 변수의 타입(클래스)을 기준으로 선택
        // 인스턴스 내부에 같은 타입인 ElectricCar 를 통해서 charge() 를 호출
        electricCar.charge();

        electricCar.move(); // 자식 타입에 해당 기능이 없으면 부모 타입으로 올라가서 찾음 -> 컴파일 오류

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
    }
}
