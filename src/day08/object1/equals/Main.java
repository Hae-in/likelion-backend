package day08.object1.equals;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.equals(p3)); // false

        // HashSet, HashMap 등에서 사용
        Set<Point> points = new HashSet<>();
        points.add(p1);
        points.add(p2); // 동일한 객체로 인식, 추가되지 않음
        System.out.println(points.size()); // 1
    }
}
