package day03;

public class ForGugudan {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                int result = i * j;
                System.out.print(j + " * " + i + " = " + result + "\t");
            }
            System.out.println();
        }
    }
}
