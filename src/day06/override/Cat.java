package day06.override;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹~");
    }

    @Override
    public void move() {
        System.out.println("고양이가 살금살금 걷습니다.");
    }

    // Cat만의 고유 메소드
    public void scratch() {
        System.out.println("할퀴기!");
    }
}
