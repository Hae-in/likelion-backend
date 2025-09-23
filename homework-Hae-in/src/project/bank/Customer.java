package project.bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int customerId; // 한 번 부여되면 변하지 않으므로 final 지정
    private String name;
    private final List<Account> accounts;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "고객번호: " + customerId +
                ", 이름: " + name +
                ", 보유계좌 수: " + accounts.size();
    }
}
