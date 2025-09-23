package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public boolean insertDept(int deptno, String dname, String loc) {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";

        boolean resultFlag = false;

        try (// 1. 접속 -- Connection
             Connection conn = DriverManager.getConnection(url, user, password);

             // 2. 쿼리 작성 --  Statement, PreparedStatement, CallableStatement
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            // 반드시 ?에 값을 채워줘야함
            ps.setInt(1, deptno); // 해당 ? 번호
            ps.setString(2, dname);
            ps.setString(3, loc);

            // 3. 실행
            int resultCount = ps.executeUpdate(); // int 리턴, delete, update 같이 한건 일 경우

            if(resultCount == 1) {
                resultFlag = true;
                System.out.println("입력 성공!");
            } else {
                System.out.println("입력 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultFlag;
    }

    public static void main(String[] args) {
        InsertTest insertTest = new InsertTest();
        boolean result = insertTest.insertDept(90, "liom", "seoul");
        System.out.println(result);
    }
}
