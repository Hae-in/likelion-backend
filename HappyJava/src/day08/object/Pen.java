package day08.object;

import java.util.Objects;

public class Pen {
    // 추상화해서 toString, equals 메서드를 오버라이드해보세요.
    private String name;
    private String color;
    private String type;
    private int price;
    private double ballPointSize;

    public Pen(String name, String color, String type, int price, double ballPointSize) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.price = price;
        this.ballPointSize = ballPointSize;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getBallPointSize() {
        return ballPointSize;
    }

    public void setBallPointSize(double ballPointSize) {
        this.ballPointSize = ballPointSize;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Double.compare(ballPointSize, pen.ballPointSize) == 0 && Objects.equals(name, pen.name) && Objects.equals(color, pen.color) && Objects.equals(type, pen.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, type, ballPointSize);
    }

    @Override
    public String toString() {
        return "Pen{" + "name='" + name + '\'' + ", color='" + color + '\'' + ", type='" + type + '\'' + ", price=" + price + ", ballPointSize=" + ballPointSize + '}';
    }

    public static void main(String[] args) {
        Pen pen1 = new Pen("153 클립 파스텔", "black", "유성볼펜", 1000, 0.5);
        Pen pen2 = new Pen("에어롱 사인펜", "black", "사인펜", 1000, 1.5);

        System.out.println(pen1.toString());
        System.out.println(pen1.equals(pen2));
    }
}
