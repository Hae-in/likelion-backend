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
}
