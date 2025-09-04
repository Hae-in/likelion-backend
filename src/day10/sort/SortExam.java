package day10.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortExam {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("numbers = " + numbers);

        Collections.shuffle(numbers);
        System.out.println("shuffle numbers = " + numbers);

        Collections.sort(numbers);
        System.out.println("sort numbers = " + numbers);

        Collections.reverse(numbers);
        System.out.println("reverse numbers = " + numbers);
    }
}
