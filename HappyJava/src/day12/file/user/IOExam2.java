package day12.file.user;

import java.io.*;

public class IOExam2 {

    // 사용자의 정보(이름, 전화번호, 주소) 를 입력 받아서 파일에 저장하는 메서드
    public void saveUserInfo() {
        String name = null;
        String phoneNumber = null;
        String address = null;

        // append: true 로 설정하면 덮어쓰지 않고 기존 내요 다음에 추가.
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/day12/file/user/userInfo.txt", true)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            for (int count = 0; count < 3; count++) {
                System.out.println("이름 : ");
                name = br.readLine();

                System.out.println("전화번호 : ");
                phoneNumber = br.readLine();

                System.out.println("주소 : ");
                address = br.readLine();

                pw.println(name + " " + phoneNumber + " " + address);
            }
            pw.close();
            System.out.println("사용자 정보가 src/day12/file/user/userInfo.txt 에 저장되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 파일로부터 읽어와서 사용자의 정보를 출력하는 메서드
    public void printUserInfo() {
        String userInfo = null;

        try (BufferedReader br = new BufferedReader(new FileReader("src/day12/file/user/userInfo.txt"));) {
            System.out.println();
            System.out.println("src/day12/file/user/userInfo.txt 의 내용은...");
            while ((userInfo = br.readLine()) != null) {
                System.out.println(userInfo);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        IOExam2 io = new IOExam2();
        io.printUserInfo();
    }
}
