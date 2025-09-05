package day12.file.user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 컬렉션에 저장하는 방법
public class IOExam3 {

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

    // 5건정도를 입력 받아서 Collection 에 저장하고, 저장이 끝나면 해당 컬렉션의 내용을 파일에 저장하는 메서드를 만들어 보세요.
    public void saveUserInfo(List<Person> personList) {

    }


    // 컬렉션의 값을 일겅와서 파일에 저장


    // 파일의 값을 읽어서 컬렉션에 저장


    public static void main(String[] args) {
        IOExam3 io = new IOExam3();

        List<Person> personList = new ArrayList<>();
        io.saveUserInfo(personList);

        System.out.println(personList.size());

        // 리스트의 정보를 파일에 저장 하는 메서드

    }
}
