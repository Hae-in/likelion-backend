package day07.interface1;

public class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("사각형을 그립니다.");
    }

    @Override
    public void erase() {
        System.out.println("사각형을 지웁니다.");
    }
}
