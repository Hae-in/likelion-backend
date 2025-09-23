package day02;

public class NestedIfExam {
    public static void main(String[] args) {
        int price = 030;
        boolean isMember = true;
        boolean hasCoupon = true;

        if (isMember) {
            if (price >= 100000) {
                if (hasCoupon) {
                    System.out.println("💰 멤버십 + 10만원 이상 + 쿠폰 적용 → 30% 할인!");
                } else {
                    System.out.println("💰 멤버십 + 10만원 이상 → 20% 할인!");
                }
            } else {
                System.out.println("💰 멤버십 → 10% 할인!");
            }
        } else {
            System.out.println("❌ 할인 없음 (비회원)");
        }
    }
}
