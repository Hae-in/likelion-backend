package day06.override;

public class Zoo {
    public static void main(String[] args) {
        // 다형성 : 부모 타입으로 자식 객체 참조
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Animal();

        System.out.println("\n=== Animals ===");
        for (Animal animal : animals) {
            animal.makeSound(); // 각 동물의 오버라이딩된 메소드 호출
            animal.move();
            System.out.println("---");
        }

        // instanceof 연산자로 실제 타입 확인
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal; // 다운캐스팅
                dog.wagTail();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.scratch();
            }
        }
    }
}
