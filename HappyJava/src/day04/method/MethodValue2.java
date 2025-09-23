package day04.method;

public class MethodValue2 {
    public static void main(String[] args) {
        int num1 = 5;
        System.out.println("changeNumber 호출 전, num1 = " + num1); // 5
        num1 = changeNumber(num1);
        System.out.println("changeNumber 호출 후, num1 = " + num1); // 5: num1의 값 5을 복사해서 num2에 전달 -> 이 부분이 핵심
    }

    public static int changeNumber(int num2) {
        num2 = num2 * 2;
        return num2;
    }
}
