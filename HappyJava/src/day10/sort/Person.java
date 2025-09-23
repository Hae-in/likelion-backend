package day10.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return this.age - other.age; // 나이를 기준으로 오름차순 정렬
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice", 32));
        people.add(new Person("Bob", 24));
        people.add(new Person("Charlie", 28));

        Collections.sort(people); // Comparable을 사용한 정렬

        for (Person person : people) {
            System.out.println(person);
        }
    }
}