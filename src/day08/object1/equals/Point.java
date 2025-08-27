package day08.object1.equals;

import java.util.Objects;

// equals(), hashCode() 메소드 : 객체의 동등성을 비교
// equals()와 hashCode() 규약
//  - equals()가 true면 hashCodee()도 같아야 함
//  - hashCode()가 같다고 equals()가 true인 것은 아님
//  - 둘 중 하나를 오버라이딩하면 다른 하나도 오버라이딩 필수
public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y); // Java 7+
        // 또는 return 31 * x + y;
    }
}
