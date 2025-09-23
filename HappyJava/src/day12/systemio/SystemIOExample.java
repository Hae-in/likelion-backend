package day12.systemio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIOExample {
    public static void main(String[] args) {
        // System.in 을 BufferedReader로 감싸기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // System.out 으로 프롬프트 출력
            System.out.println("이름을 입력하세요: ");
            String name = reader.readLine();

            System.out.println("나이를 입력하세요: ");
            int age = Integer.parseInt(reader.readLine());

            // 정상 출력
            System.out.println("안녕하세요, " + name + "님!");
            System.out.println("당신은 " + age + "살입니다.");

            // 오류 출력 예시
            if (age < 0) {
                System.out.println("오류: 나이는 음수일 수 없습니다.");
            }
        } catch (IOException e) {
            System.out.println("입력 오류: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식 오류: " + e.getMessage());
        }
    }
}
