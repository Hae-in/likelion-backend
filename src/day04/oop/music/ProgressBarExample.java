package day04.oop.music;

public class ProgressBarExample {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String CYAN = "\033[36m";

    public static void main(String[] args) throws InterruptedException {
        int total = 50;

        for (int i = 0; i <= total; i++) {
            String bar = "=".repeat(i) + " ".repeat(total - i);
            System.out.printf("\r[%s] %d%%", bar, i * 100 / total);
            Thread.sleep(100); // 진행 속도 조절
        }

        System.out.println("\n완료!");

        char[] spinner = {'|', '/', '-', '\\'};
        for (int i = 0; i < 50; i++) {
            System.out.print("\r로딩 중... " + spinner[i % spinner.length]);
            Thread.sleep(100);
        }
        System.out.println("\n완료!");

        System.out.println(RED + "빨간색 텍스트" + RESET);
        System.out.println(GREEN + "초록색 텍스트" + RESET);
        System.out.println(YELLOW + "노란색 텍스트" + RESET);
        System.out.println(BLUE + "파란색 텍스트" + RESET);

        for (int i = 0; i <= total; i++) {
            // 색상 선택 (구간에 따라 바뀌게)
            String color;
            if (i < total * 0.3) color = RED;
            else if (i < total * 0.6) color = YELLOW;
            else if (i < total * 0.9) color = BLUE;
            else color = GREEN;

            // 프로그레스바 문자열 생성
            String bar = "=".repeat(i) + " ".repeat(total - i);

            // 같은 줄 덮어쓰기 (\r)
            System.out.printf("\r%s[%s]%s %d%%", color, bar, RESET, i * 100 / total);

            Thread.sleep(100); // 속도 조절
        }

        System.out.println("\n" + CYAN + "✅ 완료!" + RESET);

        for (int i = 0; i <= total; i++) {
            // 색상 구간
            String color;
            if (i < total * 0.3) color = RED;
            else if (i < total * 0.6) color = YELLOW;
            else if (i < total * 0.9) color = BLUE;
            else color = GREEN;

            // 채워진 부분과 남은 부분
            String filled = "█".repeat(i);      // 꽉 찬 블록
            String empty = "░".repeat(total - i); // 빈 블록

            // 진행률 %
            int percent = i * 100 / total;

            // 한 줄 덮어쓰기
            System.out.printf("\r%s[%s%s]%s %3d%%", color, filled, empty, RESET, percent);

            Thread.sleep(150); // 속도 조절
        }

        System.out.println("\n" + CYAN + "🚀 완료!" + RESET);
    }
}
