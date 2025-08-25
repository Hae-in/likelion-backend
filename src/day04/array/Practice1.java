package day04.array;

import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {
        // 길이가 10인 int형 배열을 만들고, 1~10의 값을 저장한 후 짝수만 출력하세요.
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
            if (num[i] % 2 == 0) {
                System.out.println(num[i]);
            }
        }

        int[][] arr1 = new int[2][];
        System.out.println(Arrays.deepToString(arr1));
    }
}
