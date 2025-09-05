package day12.Scanner;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("정수를 입력하세요: ");
            int intValue = scanner.nextInt();

            System.out.println("실수를 입력하세요: ");
            double doubleValue = scanner.nextDouble();

            System.out.println("true/false를 입력하세요: ");
            boolean boolValue = scanner.nextBoolean();

            // 버퍼 비우기 (nextLine() 전에 필요)
            scanner.nextLine();

            System.out.println("문자열을 입력하세요: ");
            String stringValue = scanner.nextLine();

            System.out.println("=== 입력 결과 ===");
            System.out.println("정수" + intValue);
            System.out.println("실수" + doubleValue);
            System.out.println("불린" + boolValue);
            System.out.println("문자열" + stringValue);

        } finally {
            scanner.close();
        }
    }
}
