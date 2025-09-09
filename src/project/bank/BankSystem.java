package project.bank;

import java.util.ArrayList;
import java.util.List;

// 전체 시스템 관리
public class BankSystem {
    private List<Account> accounts;
    private String currentUser;

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
        Account foundAccount = findByAccountId(accountId);
        if (foundAccount != null) {
            System.out.println("계좌번호: " + foundAccount.getId());
            System.out.println("이름: " + foundAccount.getName());
            System.out.println("잔액: " + foundAccount.getBalance() + "원");
        } else {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        }
    }

    private Account findByAccountId(String accountId) {
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
}
