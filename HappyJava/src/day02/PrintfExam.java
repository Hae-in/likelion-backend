package day02;

public class PrintfExam {
    public static void main(String[] args) {
        String name = "Kim";
        int age = 10;
        double height = 175.2;
        char grade = 'A';
        boolean b = true;

        // %s : 문자열
        // %d : 정수
        // %f : 실수
        // %c : 문자
        // %b : 논리값
        // %n : 줄바꿈

        System.out.println("name = " + name + ", age = " + age);
        System.out.printf("name = %s, age = %d\n", name, age);

        // printf로 포맷팅된 출력
        System.out.printf("이름: %s%n", name);
        System.out.printf("나이: %d세%n", age);
        System.out.printf("키: %.1fcm%n", height);
        System.out.printf("학점: %c%n", grade);

        // 여러 값을 한 번에 출력
        System.out.printf("%s님은 %d세이고, 키는 %.1fcm입니다. %b %n", name, age, height, b);

        // 숫자 포맷팅
        double pi = 3.141592653589793;
        System.out.printf("파이: %.2f%n", pi);  // 소수점 2자리
        System.out.printf("파이: %.4f%n", pi);  // 소수점 4자리

    }
}
