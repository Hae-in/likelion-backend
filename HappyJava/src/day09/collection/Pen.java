package day09.collection;

import java.util.Objects;

public class Pen {
    String color;

    public Pen() {
    }

    public Pen(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + " pen";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
}
