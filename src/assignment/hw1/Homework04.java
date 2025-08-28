package assignment.hw1;

public class Homework04 {
    public static void main(String[] args) {
        // 구구단을 출력하는 프로그램을 작성하세요. (2단\~9단)
        for (int i = 1; i <= 9; i++) {
            for(int j = 2; j <= 9; j++) {
                System.out.print(j + "*" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }
}
