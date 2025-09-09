package project.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 전체 시스템 관리
public class BankSystem {
    private List<Account> accounts;
    private String currentUser;
    private boolean isLoggedIn;

    public BankSystem() {
        this.accounts = new ArrayList<>();
        this.currentUser = null;
    }

    public void createAccount(String name) {
        String accountId = generateAccountId();
        Account account = new Account(accountId, name);
        accounts.add(account);
        System.out.println("계좌 생성 완료! 계좌 번호: " + accountId);
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("등록된 계좌가 없습니다.");
        } else {
            for (Account account : accounts) {
                System.out.println("계좌 번호: " + account.getId() + ", 이름: " + account.getName());
            }
        }
    }

    public void displayAccountDetails(String accountId) {
        Account foundAccount = findAccountById(accountId);
        if (foundAccount != null) {
            System.out.println("계좌번호: " + foundAccount.getId());
            System.out.println("이름: " + foundAccount.getName());
            System.out.println("잔액: " + foundAccount.getBalance() + "원");
        } else {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        }
    }

    private Account findAccountById(String accountId) {
        for (Account account : accounts) {
            if (account.getId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    private String generateAccountId() {
        return String.valueOf(accounts.size() + 1);
    }

    public void deposit(String accountId, double amount) {
        Account account = findAccountById(accountId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("입금 완료. 현재 잔액: " + account.getBalance() + "원");
        } else {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        }
    }

    public void withdraw(String accountId, double amount) {
        Account account = findAccountById(accountId);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("출금 완료. 현재 잔액: " + account.getBalance() + "원");
        } else if (account == null) {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    public void transfer(String fromAccountId, String toAccountId, double amount) {
        Account fromAccount = findAccountById(fromAccountId);
        Account toAccount = findAccountById(toAccountId);

        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            System.out.println("이체 완료.");
            System.out.println("출금 계좌 잔액: " + fromAccount.getBalance() + "원");
            System.out.println("입금 계좌 잔액: " + toAccount.getBalance() + "원");
        } else if (fromAccount == null || toAccount == null) {
            System.out.println("계좌 정보를 확인해주세요.");
        } else {
            System.out.println("출금 계좌의 잔액이 부족합니다.");
        }
    }

    public void deleteAccount(String accountId) {
        Account account = findAccountById(accountId);
        if (account != null) {
            accounts.remove(account);
            System.out.println("계좌 삭제 완료");
        } else {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        }
    }

    public boolean login(String username, String password) {
        if (username.equals("admin") && password.equals("admin") || (username.equals(currentUser) && password.equals("12345"))) {
            isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        isLoggedIn = false;
        currentUser = null;
    }

    public boolean isAdminLoggedIn() {
        return isLoggedIn && currentUser.equals("admin");
    }

    public boolean isUserLoggedIn() {
        return isLoggedIn && !currentUser.equals("admin");
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n은행 계좌 관리 시스템");
            System.out.println("-------------------");
            System.out.println("1. 로그인 (관리자)");
            System.out.println("2. 로그인 (일반 사용자)");
            System.out.println("3. 계좌 생성");
            System.out.println("4. 계좌 목록 보기");
            System.out.println("5. 계좌 상세 정보 보기");
            System.out.println("6. 입금");
            System.out.println("7. 출금");
            System.out.println("8. 이체");
            System.out.println("9. 계좌 삭제");
            System.out.println("10. 프로그램 종료");

            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logginAdmin(scanner);
                    break;
                case 2:
                    logginUser(scanner);
                    break;
                case 3:
                    createAccount(scanner);
                    break;
                case 4:
                    displayAllAccounts();
                    break;
                case 5:
                    displayAccountDetails(scanner);
                    break;
                case 6:
                    deposit(scanner);
                    break;
                case 7:
                    withdraw(scanner);
                    break;
                case 8:
                    transfer(scanner);
                    break;
                case 9:
                    deleteAccount(scanner);
                case 10:
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");

            }
        }
    }

    private void logginAdmin(Scanner scanner) {
        System.out.print("관리자 ID: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        if (login(username, password)) {
            currentUser = "admin";
            System.out.println("관리자 로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }
    }

    private void logginUser(Scanner scanner) {
        System.out.print("사용자 이름: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        if (login(username, password)) {
            currentUser = username;
            System.out.println("사용자 로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }
    }

    private void createAccount(Scanner scanner) {
        System.out.print("계좌주 이름: ");
        String name = scanner.nextLine();

        createAccount(name);
    }

    private void displayAccountDetails(Scanner scanner) {
        System.out.print("계좌번호: ");
        String accountId = scanner.nextLine();

        displayAccountDetails(accountId);
    }

    private void deposit(Scanner scanner) {
        System.out.print("계좌번호: ");
        String accountId = scanner.nextLine();
        System.out.print("입금 금액: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        deposit(accountId, amount);
    }

    private void withdraw(Scanner scanner) {
        System.out.print("계좌번호: ");
        String accountId = scanner.nextLine();
        System.out.print("출금 금액: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        withdraw(accountId, amount);
    }

    private void transfer(Scanner scanner) {
        System.out.print("출금 계좌번호: ");
        String fromAccountId = scanner.nextLine();
        System.out.print("입금 계좌번호: ");
        String toAccountId = scanner.nextLine();
        System.out.print("이체 금액: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        transfer(fromAccountId, toAccountId, amount);
    }

    private void deleteAccount(Scanner scanner) {
        System.out.print("삭제할 계좌번호: ");
        String accountId = scanner.nextLine();

        deleteAccount(accountId);
    }
}
