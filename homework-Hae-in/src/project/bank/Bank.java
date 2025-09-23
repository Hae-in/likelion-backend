package project.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<Integer, Customer> customers;
    private Map<String, Account> accounts;
    private int nextCustomerId;
    private int nextAccountSeq;

    public Bank() {
        customers = new HashMap<>();
        accounts = new HashMap<>();
        nextCustomerId = 1;
        nextAccountSeq = 1;
    }

    // 고객 등록
    public Customer addCustomer(String name) {
        int customerId = nextCustomerId++;
        Customer customer = new Customer(customerId, name);
        customers.put(customerId, customer);
        return customer;
    }

    // 모든 고객 목록 조회
    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("등록된 고객이 없습니다!");
            return;
        }
        customers.forEach((k, v) -> System.out.println(v));
    }

    // 계좌 생성 (계좌번호 자동 발급)
    public Account createAccount(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            System.out.println("해당 ID의 고객이 존재하지 않습니다.");
            return null;
        }

        // String accountNumber = "000000-00-000000"; // 계좌번호 생성 메소드 추가
        String accountNumber = generateAccountNumber(); // 계좌번호 생성 메소드 추가
        Account account = new CheckingAccount(accountNumber, customer); // 자유로운 입출금 계좌

        // 은행 전체 계좌 목록에 추가 (Map)
        accounts.put(accountNumber, account);

        // 고객 계좌 목록에 추가 (List)
        customer.addAccount(account);

        System.out.println("계좌 개설 완료: \n" + account);
        return account;
    }

    private String generateAccountNumber() {
        // 계좌번호 포맷 00001111-00-000000
        //    * 앞 6자리: 은행 코드 + 지역/지점 코드(임의생성) => 다음 기회에...
        //    * 중간 2자리: 상품 타입 코드(예: 01=입출금, 02=예금)
        //    * 마지막 6자리: 순번(자동 증가)
        String bankBranch = "00";
        String productCode = "01";
        String seq = String.format("%02d", nextAccountSeq++);

        return String.format("%s-%s-%s", bankBranch, productCode, seq);
    }

    // 보유 계좌 목록 조회 => 계좌 정렬 옵션 추가 가능 (잔액 기준, 계좌번호 기준, 계좌 타입 등)
    public void listAccountsByCustomer(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            System.out.println("해당 ID(" + customerId + ")의 고객이 존재하지 않습니다.");
            return;
        }

        List<Account> accounts = customer.getAccounts();
        if(accounts == null || accounts.isEmpty()) {
            System.out.println("보유한 계좌가 없습니다.");
            return;
        }
        accounts.forEach(account -> System.out.println(account));
        // customer.getAccounts().forEach(System.out::println);
    }

    // 계좌 조회
    public Account searchAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if(account == null) {
            System.out.println("해당 계좌번호(" + accountNumber + ")는 존재하지 않습니다.");
        }
        return account;
    }

    // 계좌 삭제
    public void deleteAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);

        if(account == null) {
            System.out.println("해당 계좌번호(" + accountNumber + ")는 존재하지 않습니다.");
        }

        // 삭제 순서 ⭐⭐⭐
        account.getOwner().getAccounts().remove(account); // 고객 계좌 목록에서 삭제 (List)
        accounts.remove(accountNumber); // 은행 전체 계좌 목록에서 삭제 (Map)

        System.out.println("계좌 삭제 완료: " + accountNumber);
    }

    // 이체
    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if(account == null) {
            System.out.println("해당 계좌번호(" + accountNumber + ")는 존재하지 않습니다.");
        } else {
            account.deposit(amount);
        }
    }

    // 출금
    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if(account == null) {
            System.out.println("해당 계좌번호(" + accountNumber + ")는 존재하지 않습니다.");
        } else {
            account.withdraw(amount);
        }
    }

    // 송금
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        if(amount <= 0) {
            System.out.println("송금 금액은 0보다 커야 합니다.");
            return;
        }

        Account from = accounts.get(fromAccountNumber);
        Account to = accounts.get(toAccountNumber);

        if(from == null) {
            System.out.println("해당 계좌번호(" + fromAccountNumber + ")는 존재하지 않습니다.");
            return;
        }
        if(to == null) {
            System.out.println("해당 계좌번호(" + toAccountNumber + ")는 존재하지 않습니다.");
            return;
        }

        try {
            from.withdraw(amount); //출금
            to.deposit(amount); //입금
            System.out.println("송금 완료: " + fromAccountNumber + " → " + toAccountNumber + ", 금액: " + amount);
        } catch (IllegalArgumentException e) { // 사용자가 잘못된 값(음수, 0, 잔액 부족 등)을 입력했을 때
            System.out.println("송금 실패: " + e.getMessage());
        }
    }
}
