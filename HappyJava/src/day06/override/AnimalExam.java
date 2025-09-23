package day06.override;

public class AnimalExam {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();

        Cat cat = new Cat();
        cat.makeSound();

        Animal animal = null;

        if ("1" == args[0]) { // 주소값을 비교하게 됨

        }

        if (Integer.parseInt(args[1]) == 1) {
            animal = new Cat();
        } else {
            animal = new Dog();
        }

        animal.move();
        animal.makeSound();

//        dog.move();
//        dog.wagTail();
//
//        cat.move();
//        cat.scratch();
    }
}
