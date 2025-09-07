package day13.ocp;

interface Payment {
    void pay(double amount);
}

class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("신용카드로 " + amount + "원 결제완료!");
    }
}

class PayPal implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("페이팔로 " + amount + "원 결제완료!");
    }
}

// 새로운 결제 수단 추가
class KakaoPay implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("카카오페이로 " + amount + "원 결제완료!");
    }
}

class PaymentProcessor {
    private final Payment payment;

    public PaymentProcessor(Payment payment) {
        this.payment = payment;
    }

    public void process(double amount) {
        payment.pay(amount);
    }
}

public class PaymentMain {
    public static void main(String[] args) {
        Payment creditCard = new CreditCard();
        Payment paypal = new PayPal();
        Payment kakaoPay = new KakaoPay();

        PaymentProcessor processor1 = new PaymentProcessor(creditCard);
        processor1.process(10000);

        PaymentProcessor processor2 = new PaymentProcessor(paypal);
        processor2.process(20000);

        PaymentProcessor processor3 = new PaymentProcessor(kakaoPay);
        processor3.process(30000);
    }
}
