package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// 예외처리를 추가
public class DeleteTest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        String sql = "delete from dept where deptno = ?";

        try (
                // 1. 접속
                Connection conn = DriverManager.getConnection(url, user, password);

                // 2. 쿼리 작성
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setInt(1, 80);

            // 3. 쿼리 실행
            int resultCount = ps.executeUpdate();

            // 4. 결과 확인
            if(resultCount > 0){
                System.out.println("삭제 완료!");
            } else {
                System.out.println("삭제 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
