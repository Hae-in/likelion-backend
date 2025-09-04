package day03;

public class ForExam3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("o");
            }
            System.out.println();
        }

        /*
        for (int i = 1; i <= 5; i++) {
            for (int j = 6; j > i; j--) {
                System.out.print("x");
            }
            System.out.println();
        }*/

    }
}
