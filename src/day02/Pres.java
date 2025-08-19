package day02;

public class Pres {
    public static void main(String[] args) {
        /*System.out.println("----- login : sc, if-else -----");
        String id = "user";
        String pw = "1234";

        Scanner sc = new Scanner(System.in);

        System.out.println("ID를 입력하세요 → ");
        String inputId = sc.nextLine();

        System.out.println("PW를 입력하세요 → ");
        String inputPw = sc.nextLine();

        if (id.equals(inputId) && pw.equals(inputPw)) {
            System.out.println("⭕️ 로그인 성공");
        } else {
            System.out.println("❌ 로그인 실패");
        }*/

        /*System.out.println("----- str 변환 -----");
        String str = "tEstStRinG";

        if (str.startsWith("t")) {
            str = str.substring(1, 4); // 문자열 잘라내기
//          str = str.toLowerCase(); // 소문자로 변환, toUpperCase(), trim(), ...
//            str = str.trim();
        }
        System.out.println(str);
*/

        System.out.println("----- nested if-else -----");
        int price = 12;
        boolean isMember = true; // 회원 여부
        boolean hasCoupon = true; // 할인쿠폰 여부

        if (isMember) {
            if (price >= 10000) {
                if (hasCoupon) {
                    System.out.println("회원 할인 + 만원이상 할인 + 쿠폰 할인 적용!");
                } else {
                    System.out.println("회원 할인 + 만원이상 할인 적용!");
                }
            } else {
                System.out.println("회원 할인 적용!");
            }
        } else {
            System.out.println("❌ 할인 없음 (비회원)");
        }
    }
}
