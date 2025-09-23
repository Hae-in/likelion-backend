package day04.array;

import java.util.Arrays;

public class MultiArrayExam {
    public static void main(String[] args) {
        // 선언 = [][] 몇개냐가 차원을 결정함.
        int[][] iarr;
        iarr = new int[3][2];

        iarr[0][0] = 100;
        iarr[0][1] = 200;
        iarr[1][0] = 300;

        int[][] iarr2 = new int[3][]; // 실제 값을 담을 수 없는 상태, 주소를 가리킴

        iarr2[0] = new int[2]; // 1차원 배열만 가능
        iarr2[1] = new int[10];
        iarr2[2] = new int[5];

        iarr2[0][0] = 10;
        iarr2[1][0] = 20;

        System.out.println(iarr2[0][0]);

        int[][][][] iarr4 = new int[3][][][]; // 첫 번째는 3차원 배열의 '주소'를 가리키는 그릇

        int[] iarr5 = {1, 2, 3};

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(matrix[2][1]); // 8

        int[][] iarr7 = {{1, 2}, {3, 4, 5, 6, 7}, {8}};
        System.out.println(iarr7[1][2]); // 5

        // 2차원 배열 순회
        System.out.println("--- 2차원 배열 출력 ---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // 가변 길이 2차원 배열
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1, 2};
        jagged[1] = new int[]{3, 4, 5};
        jagged[2] = new int[]{6, 7, 8, 9};

        System.out.println("\n----- 가변 길이 배열 -----");
        for (int[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----- 가변 길이 배열  -----\n");

        int[] iarr9 = {1, 2, 3};
        System.out.println(Arrays.toString(iarr9)); // [1, 2, 3] : 밥 밥을하다 (씻은쌀, 물) {} -- 라턴 밥
    }
}
