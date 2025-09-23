package assignment.hw2.problem02;

public class BankAccount {
    private static int totalAccounts;
    private String name;
    private final String accountNumber; //
    private double balance;

    // 생성자
    public BankAccount(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        balance = 0;
        totalAccounts++;
    }

    // 모든 거래는 성공/실패 여부를 boolean으로 반환

    // 입금
    public boolean deposit(double amount) {
        // 양수 금액만 허용
        if (amount > 0) {
            this.balance = balance + amount;
            System.out.println("⭕️ 입금 성공: 잔액: " + balance );
            return true;
        } else {
            System.out.println("❌ 입금 실패: 0보다 큰 금액만 허용됩니다. (입력: " + amount + ")");
            return false;
        }
    }

    // ⭐출금 순서: 양수인지 확인 -> 잔액 충분한지 확인
    // 잔액부터 확인하면, 음수 금액 입력 시에도 잔액부족 메시지가 먼저 출력될 수 있음!
    public boolean withdraw(double amount) {
        // 양수 금액만 허용
        if (amount <= 0) {
        System.out.println("❌ 입금 실패: 0보다 큰 금액만 허용됩니다. (입력: " + amount + ")");
            return false;
        }
        if (balance < amount) {
            System.out.println("❌ 출금 실패: 잔액이 부족합니다. (잔액: " + balance + ")");
            return false;
        }
        this.balance = balance - amount;
        System.out.println("⭕️ 출금 성공: 잔액: " + balance );
        return true;
    }

    // 계좌 이체
    // 출금 -> 성공하면 target 계좌에 입금 -> true/false
    public boolean transfer(BankAccount target, double amount) {
        if(this.withdraw(amount)) {
            target.deposit(amount);
            System.out.println("⭕️ 이체 성공: 잔액: " + balance );
            return true;
        }
        return false;
    }

    // 잔액 출력
    public void showBalance() {
        System.out.println("[" + this.name + "] 잔액: " + this.balance + "원");
    }

    // 계좌 정보 출력
    public void showAccountInfo() {
        System.out.println("===== 계좌 정보 =====");
        System.out.println("예금주: " + this.name);
        System.out.println("계좌번호: " + this.accountNumber);
        System.out.println("잔액: " + this.balance + "원\n");
    }

    // 전체 계좌 수 출력
    public static void showTotalAccounts() {
        System.out.println("전체 계좌 수: " + totalAccounts);
    }
}
