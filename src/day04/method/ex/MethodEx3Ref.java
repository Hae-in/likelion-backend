package day04.method.ex;

// 입출금 리펙토링
public class MethodEx3Ref {
    public static void main(String[] args) {
        int balance = 10000;

        balance = deposit(balance, 1000); // 입금 1000
        balance = withdraw(balance, 2000); // 출금 2000
        balance = withdraw(balance, 10000); // 출금 10000

        System.out.println("최종 잔액: " + balance + "원");
    }

    /*// 입금
    public static void deposit(int balance, int amount) {
        balance = balance + amount;
        System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
    }*/

    // 입금
    public static int deposit(int balance, int amount) {
        balance = balance + amount;
        System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
        return balance;
    }

    /*// 출금
    public static void withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니 다.");
        }
    }*/

    // 출금
    public static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}

/*
    입출금에 따라 balance의 값이 변경되도록하려면 메소드의 리턴값을 int로 지정.
 */