package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        // 1. 접속
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

        // 2. 쿼리 작성
        String sql = "update dept set dname = ? where deptno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, "교육부");
        ps.setInt(2, 80);

        // 3. 쿼리 실행
        int resultCount = ps.executeUpdate();

        // 4. 결과 확인
        if(resultCount > 0){
            System.out.println("업데이트 완료!");
        } else {
            System.out.println("업데이트 실패!");
        }
    }
}
