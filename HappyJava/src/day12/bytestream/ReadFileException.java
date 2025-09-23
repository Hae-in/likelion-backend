package day12.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFileException {
    public static void main(String[] args) {
        // 파일에서 읽어서 파일에 쓰고 싶다.

        // 스트림은 단방향으로 데이터가 흐른다 -> 입력, 출력 따로 필요
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("src/day12/input.txt"); // 절대경로: 항상 root부터 시작, 상대경로: 내가 있는 곳이 기준
            fos = new FileOutputStream("src/day12/output.txt");

            int n = 0;
            int count = 0;

            System.out.println("count = " + count);

            // 바이트 배열
            byte[] bytes = new byte[1024];
            while ((n = fis.read(bytes)) != -1) {
                // String str = new String(bytes);
                String str = new String(bytes, 0, n); // 이렇게 해야 남아있는 부분을 사용 안함(0부터 읽어온 바이트(n)까지만 사용!)
                System.out.println("str = " + str); // 실행하면 아무것도 출력안됨 -> 위의 while 문에서 이미 다 읽었기 때문에
                count++;
                fos.write(bytes, 0, n); // 파일에 작성
            }
            System.out.println("count = " + count);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (fis != null) { // if 문 없으면 NullPointerException 발생: 없는 파일명을 열려고 하면, FileStream 객체가 안만들어졌는데 close하라고해서
                try {
                    fis.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } // 너무 장황 -> 그래서 try-with-resources 사용 -> close() 안해도댐 :: close()할수 있는 애들만 (...)에 들어갈수있음
    }
}
