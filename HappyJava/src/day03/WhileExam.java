package day03;

public class WhileExam {
    public static void main(String[] args) {
        int i = 0;
        /*while (i < 10) {
            i++;
            if (i % 2 == 0) {
                System.out.println("안녕" + i);
            }
        }*/

        while (i++ < 10) {
            if (i == 5) continue;
            System.out.println(i);
        }
    }
}
