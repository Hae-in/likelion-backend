package day02;

public class SwitchExam {
    public static void main(String[] args) {
        int num = 1;
        switch (num) {
            case 1:
                System.out.println("1. 준비");
                break;
            case 2:
                System.out.println("2. 물 끓이기");
            case 3:
                System.out.println("3. 커피타기");
        }

        int month = 1;
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            default:
                System.out.println("잘못된 월");
        }
    }
}
