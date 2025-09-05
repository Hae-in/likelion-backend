package day12.file.bank;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankStep3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/day12/file/bank/transactions.txt", true));) {

            List<String> transactions = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                System.out.println("계좌번호 입력하세요: ");
                String accountName = scanner.nextLine();

                System.out.println("입금 금액을 입력하세요: ");
                long amount = scanner.nextLong();

                scanner.nextLine(); // 버퍼 비우기

                String msg = accountName + " 계좌에 " + amount + "원을 입금했습니다.";
                transactions.add(msg);
            }

            for (String transaction : transactions) {
                bw.write(transaction);
                bw.newLine();
            }
            System.out.println("거래 내역이 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
