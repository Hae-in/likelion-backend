package day03;

public class StarPattern {
    public static void main(String[] args) {
        int rows = 5;

        System.out.println("1. 직각 삼각형 (왼쪽 정렬)");
        /*
            i = 1;
            oxxxx 1 번째 줄 = 공백 4, 별 1
            ooxxx 2 번째 줄 = 공백 3, 별 2
            oooxx 3 번째 줄 = 공백 2, 별 3
            oooox 4 번째 줄 = 공백 1, 별 4
            ooooo 5 번째 줄 = 공백 0, 별 5
                  ========  =====  ====
                    rows            i
         */
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("o");
            }
            System.out.println();
        }

        System.out.println("\n2. 역직각 삼각형(오른쪽 정렬)");
        /*
            i = 1;
            xxxxx 1 번째 줄 = 공백 0, 별 5
            oxxxx 2 번째 줄 = 공백 1, 별 4
            ooxxx 3 번째 줄 = 공백 2, 별 3
            oooxx 4 번째 줄 = 공백 3, 별 2
            oooox 5 번째 줄 = 공백 4, 별 1
                  ========  =====  ====
                    rows     i-1    rows-(i-1)=rows-i+1
         */
        for (int i = 1; i <= rows; i++) {
            // 공백
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }

            // 별
            for (int j = 1; j <= rows - i + 1; j++) {
                System.out.print("o");
            }
            System.out.println();
        }

        System.out.println("\n3. 역직각 삼각형 (왼쪽 정렬)");

        for (int i = rows; 1 <= i; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("o");
            }
            System.out.println();
        }

        System.out.println("\n4. 오른쪽 정렬 삼각형");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("o");
            }
            System.out.println();
        }

        System.out.println("\n5. 피라미드");

    }
}
