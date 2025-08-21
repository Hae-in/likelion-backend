package day04;

public class VarArgsExam {
    // 객체 - 속성(값, 필드), 행위(기능, 메소드)
    // 접근제한자 리턴타입 메소드명(매개변수들...)

    // 정수 2개를 받아들여서 정수 두개를 더해서 더한값을
    // 리턴하는 add라는 이름의 메소드 정의해봅시다.
    // 누구든지 사용할 수 있도록 접근제한자를 정한다.
    public static int add(int a, int b) {
        return a + b;
    }

    // 가변 길이 매개변수
    public static int add(int... numbers) {
        int sum = 0;
        // for (int i = 0; i < numbers.length; i++) sum += numbers[i];
        for (int number : numbers) sum += number;
        System.out.println(sum);
        return 0;
    }

    // 위와 다른 부분은 동일하고, 두개의 정수를 받아서 첫번째 매개변수에서
    // 두번째 매개변수를 뺀 값을 리턴하는 minus 라는 메소드를 정의해 보세요.
    public static int minus(int a, int b) {
        return a - b;
    }

    // main - 프로그램의 시작점
    public static void main(String[] args) {
        // add라는 메소드가 메모리에 올라가있는 상태가 아님.
        // 그런데 main은 사용할수있는 이유? - static 키워드
        int result = add(1, 3);
        System.out.println(result);

        add(3, 2, 7);
        add(8, 2, 9, 3);
    }
}