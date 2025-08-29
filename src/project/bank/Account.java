package project.bank;

public abstract class Account {
    private final String accountNumber;
    private final Customer owner; // 계좌 소유주
    protected double balance; // 하위 클래스에서 제어하기 위해서 protected로 선언

    public Account(String accountNumber, Customer owner) { // Bank에서 생성된 계좌번호 전달
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "계좌번호: " + accountNumber +
                ", 소유주: " + owner.getName() +
                ", 잔액: " + balance;
    }

    // 입금 - 계좌 자체의 잔액 변화 처리
    public void deposit(double amount) {
        try {
            // 0 이하 입력 차단
            if (amount <= 0) {
                System.out.println("입금 금액은 0보다 커야 합니다.");
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("입금 실패: " + e.getMessage());
        }
        balance = balance + amount;
    }

    // 출금 - 계좌 자체의 잔액 변화 처리
    public void withdraw(double amount) {
        try {
            // 0 이하 입력 차단
            if (amount <= 0) {
                System.out.println("출금 금액은 0보다 커야 합니다.");
                return;
            }
            if (balance < amount ) {
                System.out.println("잔액 부족으로 출금할 수 없습니다.");
                return;
            }
            balance = balance - amount;
        } catch (IllegalArgumentException e) {
            System.out.println("출금 실패: " + e.getMessage());
        }
    }
}
