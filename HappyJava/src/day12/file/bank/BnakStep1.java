package day12.file.bank;

import java.util.Scanner;

public class BnakStep1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계좌번호 입력하세요: ");
        String accountName = scanner.nextLine();

        System.out.println("입금 금액을 입력하세요: ");
        long amount = scanner.nextLong();

        System.out.println(accountName + " 계좌에 " + amount + "원을 입금했습니다.");
        scanner.close();
    }
}
