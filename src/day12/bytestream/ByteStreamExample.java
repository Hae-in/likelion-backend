package day12.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {

        try {
            File inputFile = new File("src/day12/input.txt");

            // input.txt가 없으면 생성
            if (!inputFile.exists()) {
                boolean created = inputFile.createNewFile();
                if (created) {
                    System.out.println("input file이 생성되었습니다... ");
                }
            }

            // try-with-resources를 사용한 자동 리소스 관리
            try (FileInputStream in = new FileInputStream(inputFile);
                 FileOutputStream out = new FileOutputStream("src/day12/output.txt");) {

                int byteData;

                // 파일 끝(-1)까지 한 바이트씩 읽기
                while ((byteData = in.read()) != -1) {
                    out.write(byteData);
                }
                System.out.println("파일 복사 완료!");
            }
        } catch (IOException e) {
            System.out.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}
