package day09.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();

        // 이렇게 선언된 코드를 우리 많이 만나게 됩니다.
        List<String> fruits = new ArrayList<>();

        // 추가
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Banana");

        // 출력
        System.out.println("fruits = " + fruits); // toString 오버라이딩

        // 접근
        System.out.println(fruits.get(0));

        // 수정
        fruits.set(0, "Grape");
        System.out.println("fruits = " + fruits);
        System.out.println(fruits.get(0));

        // 삭제
        fruits.remove(0);
        System.out.println("fruits = " + fruits);
    }
}
