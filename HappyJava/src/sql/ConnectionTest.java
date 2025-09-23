package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        // 자바 프로그래밍도 DBMS 입장에서 클라이언드이다.
        // 1. DB 접속해야함 Connection: 접속이 추상화된 객체

        // 1. Connection은 인터페이스라 자바 표준만 정의
        // 2. MySQL 드라이버가 구현한 클래스를 제공
        // 3. Class.forName("com.mysql.cj.jdbc.Driver")는 드라이버를 등록하는 역할
        // 4. DriverManager.getConnection() 호출 시 생성

        // Class.forName은 그냥 메모리에 올리기위해 사용
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";
        con = DriverManager.getConnection(url, user, password);

        if (con != null) {
            // 성공
            System.out.println("Connection established 😆");
        } else {
            // 실패
            System.out.println("Connection failed 😞");
        }
    }
}
