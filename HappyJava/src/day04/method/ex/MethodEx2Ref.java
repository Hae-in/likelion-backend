package day04.method.ex;

// 반복 출력 리펙토링
public class MethodEx2Ref {
    public static void main(String[] args) {
        // printMessage(3);
        // printMessage(5);
        // printMessage(7);
        printMessage("Hello", 3);
        printMessage("world!", 5);
        printMessage("Java", 7);
    }

    /*public static void printMessage(int a) {
        System.out.println("반복 횟수 = " + a);
        String message = "Hello, world!";
        for (int i = 0; i < a; i++) {
            System.out.println(message);
        }
    }*/

    public static void printMessage(String msg, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(msg);
        }
    }
}
