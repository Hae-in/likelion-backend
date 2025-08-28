package day09.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
        // 중복 허용 X -> 유일성 보장
        // 순서 보장 X

        Set<String> fruits = new HashSet<>();

        // 추가
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Banana"); // 중복이여서 add 안됨

        System.out.println("fruits set = " + fruits); // [Orange, Banana]

        Set<Pen> penSet = new HashSet<>();
        penSet.add(new Pen("red"));
        penSet.add(new Pen("black"));
        penSet.add(new Pen("red"));
        penSet.add(new Pen("red"));

        System.out.println("penSet = " + penSet); // [day09.collection.Pen@2a84aee7, day09.collection.Pen@8efb846]

        // String은 중복 안된이유? -> equals()
        // equals() 생성하면 red 중복안됨!

        // set은 index를 갖고있지 않다. 왜 ? 순서가 중요하지 않은 자료구조.
        // Iterator<String> iterator = fruits.iterator();
        Iterator<Pen> iterator = penSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
