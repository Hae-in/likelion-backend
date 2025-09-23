package day12.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception { // main에 throws는 테스트 할때만 사용하기!
        // 파일에서 읽어서 파일에 쓰고 싶다.

        // 스트림은 단방향으로 데이터가 흐른다 -> 입력, 출력 따로 필요
        FileInputStream fis = new FileInputStream("src/day12/input.txt"); // 절대경로: 항상 root부터 시작, 상대경로: 내가 있는 곳이 기준
        FileOutputStream fos = new FileOutputStream("src/day12/output.txt");

        System.out.println(fis.read()); // 문자 하나 읽기
        System.out.println((char) fis.read()); // 문자 하나 읽기

        // 한번 읽었으면 끝.
        System.out.println(fis.read()); // 문자 하나 읽기
        System.out.println((char) fis.read()); // 문자 하나 읽기

        // fis.read() 가 반복되어야겠다.
        // fis.read() 했을때 파일의 끝이면 -1을 리턴

        int n = 0;
        int count = 0;


        /*// 바이트 하나씩 읽어서 쓰는 중 -> 효과 떨어짐 -> 바이트배열 읽어서 쓰는애있음
        while ((n = fis.read()) != -1) { // 파일의 끝이 아닐때까지 게속 반복
            System.out.print((char) n); // 콘솔에 출력
            fos.write(n); // 파일에 출력
            count++;
        }*/

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


        // 실제 파일에 쓰는일은 누가 할까? OS
        fis.close();
        fos.close();
    }
}
