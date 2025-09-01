package project.bank;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {

        bank.addCustomer("이해인");
        bank.addCustomer("김지영");
        bank.createAccount(1);
        bank.createAccount(1);
        bank.createAccount(2);

        while (true) {
            System.out.println("\n===== 🏦 은행 관리 시스템 =====");
            System.out.println("1. 고객 등록       2. 계좌 개설");
            System.out.println("3. 입금           4. 출금");
            System.out.println("5. 계좌 조회       6. 전체 고객 조회");
            System.out.println("7. 송금           8. 계좌 삭제");
            System.out.println("9. 종료");
            System.out.print("메뉴를 선택하세요: ");

            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    System.out.print("등록할 고객 이름: ");
                    String name = scanner.nextLine();
                    bank.addCustomer(name);
                    break;
                case 2:
                    System.out.print("계좌를 개설할 고객 ID: ");
                    int customerId = Integer.parseInt(scanner.nextLine());
                    bank.createAccount(customerId);
                    break;
                case 3:
                    System.out.print("입금할 계좌번호: ");
                    String depositAccNum = scanner.nextLine();
                    System.out.print("입금액: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    bank.deposit(depositAccNum, depositAmount);
                    break;
                case 4:
                    System.out.print("출금할 계좌번호: ");
                    String withdrawAccNum = scanner.nextLine();
                    System.out.print("출금액: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    bank.withdraw(withdrawAccNum, withdrawAmount);
                    break;
                case 5:
                    System.out.print("조회할 계좌번호: ");
                    String findAccNum = scanner.nextLine();
                    Account account = bank.searchAccount(findAccNum);
                    if (account != null) {
                        System.out.println("--- 계좌 정보 ---");
                        System.out.println(account);
                        System.out.println("-----------------");
                    }
                    break;
                case 6:
                    bank.listAllCustomers();
                    break;
                case 7:
                    System.out.print("출금할 계좌번호: ");
                    String fromAccNum = scanner.nextLine();
                    System.out.print("입금할 계좌번호: ");
                    String toAccNum = scanner.nextLine();
                    System.out.print("송금액: ");
                    double transferAmount = Double.parseDouble(scanner.nextLine());
                    bank.transfer(fromAccNum, toAccNum, transferAmount);
                    break;
                case 8:
                    System.out.print("삭제할 계좌번호: ");
                    String deleteAccNum = scanner.nextLine();
                    bank.deleteAccount(deleteAccNum);
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ 잘못된 메뉴 선택입니다. 1~7 사이의 숫자를 입력해주세요.");
            }
        }
    }
}
