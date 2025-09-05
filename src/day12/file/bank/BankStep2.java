package day12.file.bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BankStep2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/day12/file/bank/transactions.txt", true));) {

            System.out.println("계좌번호 입력하세요: ");
            String accountName = scanner.nextLine();

            System.out.println("입금 금액을 입력하세요: ");
            long amount = scanner.nextLong();

            String msg = accountName + " 계좌에 " + amount + "원을 입금했습니다.\n";
            bw.write(msg);

            System.out.println("거래 내역이 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
