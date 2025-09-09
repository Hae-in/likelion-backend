package project.bank;

import java.util.ArrayList;
import java.util.List;

// 전체 시스템 관리
public class BankSystem {
    private List<Account> accounts;
    private String currentUser;
    private boolean isLoggedIn;

    public BankSystem() {
        this.accounts = new ArrayList<>();
        this.currentUser = null;
    }

    public void createAccount(String id, String name) {
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

    public void displayAllAccountDetails(String accountId) {
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
}
