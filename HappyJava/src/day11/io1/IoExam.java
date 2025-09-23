package day11.io1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IoExam {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);

        String msg; // 입력 내용을 담을 변수

        while ((msg = br.readLine()) != null) {
            if (msg.equals("exit")) {
                break;
            }
            System.out.println("내용: " + msg);
        }
    }
}
