package day11.io1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam {
    public static void main(String[] args) {
        // try-with-resources를 사용한 자동 리소스 관리
        try (FileInputStream in = new FileInputStream("src/day11/io/input.txt"); FileOutputStream out = new FileOutputStream("src/day11/io/output.txt")) {
            int byteData;

            // 파일 끝(-1)까지 한 바이트씩 읽기
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
            System.out.println("파일 복사 완료!");
        } catch (IOException e) {
            System.out.println("파일 처리 중 오류: " + e.getMessage());
        }
    }
}
