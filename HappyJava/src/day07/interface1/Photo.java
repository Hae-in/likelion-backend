package day07.interface1;

public class Photo implements Drawable, Resizable {
    private String filename;
    private int width, height;

    public Photo(String filename, int width, int height) {
        this.filename = filename;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(filename + " 사진을 화면에 그립니다.");
    }

    @Override
    public void erase() {
        System.out.println(filename + " 사진을 화면에서 지웁니다.");
    }

    @Override
    public void resize(double factor) {
        width = (int) (width * factor);
        height = (int) (height * factor);
        System.out.println("크기 조정: " + width + "x" + height);
    }
}
