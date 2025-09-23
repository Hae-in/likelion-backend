package day06.vehicle;

public class VehicleTest {
    public static void main(String[] args) {
        /*Car car = new Car("현대", "소나타", 2023, 4); // 상속 괸계인 Vehicle 인스턴스도 같이 생성
        Motorcycle bike = new Motorcycle("할리데이비슨", "스포츠스터", 2022, "크루저");

        System.out.println("=== 자동차 정보 ===");
        car.displayInfo();
        car.start(); // 부모 클래스
        car.openTrunk();
        car.stop(); // 부모 클래스

        System.out.println("\n=== 오토바이 정보 ===");
        bike.displayInfo();
        bike.start(); // 부모 클래스
        bike.wheelie();
        bike.stop(); // 부모 클래스*/

        // 업캐스팅 : 자식 객체를 부모 타입 참조 변수에 담기
        //  - 컴파일러가 암묵적으로 허용 (명시적 캐스팅 불필요)
        Vehicle car = new Car("기아", "과학5호기", 2024, 4);
        Vehicle motorcycle = new Motorcycle("Kawasaki", "Ninja 400", 2023, "Sport");

        // 상속 + 오버라이딩 확인
        //  - displayInfo()는 Car/Motorcycle에서 오버라이딩되어 동적 바인딩으로 자식 구현이 호출 됨
        //  - 각 자식의 displayInfo() 내부에서 super.display() 호출 -> 부모 공통 정보 + 자식 확장 정보 출력!
        car.displayInfo();
        motorcycle.displayInfo();

        // 부모의 공통 기능 사용 (상속으로 물려받은 메서드)
        car.start();
        car.stop();
        motorcycle.start();
        motorcycle.stop();

        // polymorphism : 동일한 부모 타입 배열에 서로 다른 자식 타입을 담아 일괄 처리
        Vehicle[] garage = new Vehicle[]{car, motorcycle, new Car("테슬라", "Model 3", 2024, 4), new Motorcycle("Yamaha", "MT-07", 2021, "Naked")};

        for (Vehicle v : garage) {
            // 동적 바인딩으로 각 타입의 오버라이딩 메서드 실행
            v.displayInfo();
        }
        System.out.println("==================");

        // 다운 캐스팅 : instanceof로 타입 체크 후 자식 전용 기능 호출     - 런타임 예외(ClassCastException)
        for (Vehicle v : garage) {
            if (v instanceof Car) {
                ((Car) v).openTrunk();
            } else if (v instanceof Motorcycle) {
                ((Motorcycle) v).wheelie();
            }
        }

        for (Vehicle v : garage) {
            if (v instanceof Car c) {
                c.openTrunk();
            } else if (v instanceof Motorcycle m) {
                m.wheelie();
            }
        }

        // super()와 super. 사용 위치
        //  - super(): Car/ Motorcycle 생성자에서 부모 생성자 Vehicle(String, String, int) 호출
        //  - super.: Car.displayInfo(), Motorcycle.displayInfo()에서 부모의 displayInfo()를 먼저 실행
        System.out.println("\n=== super() / super. 설명 ===");
        System.out.println("Car/ Motorcycle 생성자에서 super(brand, model, year)로 부모 생성자 호출.");
        System.out.println("오버라이딩된 displayInfo() 안에서 super.displayInfo()로 공통 정보 먼저 출력.");

        // 같은 패키지이므로 protected 필드 접근 가능     - 실무에서는 getter 사용
        System.out.println("브랜드(garage[0]): " + garage[0].brand);
        System.out.println("모델(garage[0]): " + garage[0].model);
        System.out.println("연식(garage[0]): " + garage[0].year);
    }
}