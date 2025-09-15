package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// 삭제만 되도록 구현
public class DeleteTest1 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        // 1. 접속
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

        // 2. 쿼리 작성
        String sql = "delete from dept where deptno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, 80);

        // 3. 쿼리 실행
        int resultCount = ps.executeUpdate();

        // 4. 결과 확인
        if(resultCount > 0){
            System.out.println("삭제 완료!");
        } else {
            System.out.println("삭제 실패!");
        }

        ps.close();
        conn.close();
    }
}
