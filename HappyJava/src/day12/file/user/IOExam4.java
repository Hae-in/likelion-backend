package day12.file.user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 컬렉션에 저장하는 방법
public class IOExam4 {

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

    // 컬렉션의 값을 일겅와서 파일에 저장
    public void saveUsersToFile(List<Person> personList) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/day12/file/user/userInfo.txt", true));) {
            for (Person person : personList) {
                pw.printf("%s %s %s\n", person.getName(), person.getPhoneNumber(), person.getAddress());

                // Person의 toString을 우리가 출력하기 원하는 형태로 오버라이딩
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 파일의 값을 읽어서 컬렉션에 저장
    public void readUsersFromFile(List<Person> personList, String fileName) {
        String userInfo = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((userInfo = br.readLine()) != null) {
                String[] info = userInfo.split(" ");
                Person person = new Person(info[0], info[1], info[2]);
                personList.add(person);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        IOExam4 io = new IOExam4();
        List<Person> personList = new ArrayList<>();

        io.readUsersFromFile(personList, "src/day12/file/user/userInfo.txt");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
