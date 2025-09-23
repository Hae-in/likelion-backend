package day08.enum1;

public class EnumTest {
    public static void main(String[] args) {
        // 요일 값을 저장하고 싶다.
        String day;
        day = "Monday";
        day = "Tuesday";


        // 열거형 사용
        Day today = Day.WEDNESDAY;

        // 열거형 타입을 선언해 줌으로서 잘못된 값이 들어가지 않는다.
        // today =

        // switch문에서 사용
        switch (today) {
            case MONDAY:
            case FRIDAY:
                System.out.println("평일입니다.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("주말입니다.");
                break;
        }

        // OrderStatus 사용
        OrderStatus status = OrderStatus.PENDING;
        System.out.println(status.getDescription());  // 대기중

        // 모든 값 순회
        for (OrderStatus s : OrderStatus.values()) {
            System.out.println(s.name() + ": " + s.getDescription());
        }

        // 코드로 찾기
        OrderStatus found = OrderStatus.fromCode("S");
        System.out.println(found);  // SHIPPED
    }
}
