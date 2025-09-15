package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 메서드로 작성해서 main에서는 해당 메서드를 사용하는 것으로 코드를 수정
public class DeleteTest3 {
    public int deleteDept(int deptno) {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        String sql = "delete from dept where deptno = ?";

        int resultCount = 0;

        try (
                // 1. 접속
                Connection conn = DriverManager.getConnection(url, user, password);

                // 2. 쿼리 작성
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, deptno); // deptno

            // 3. 쿼리 실행
            resultCount = ps.executeUpdate();

            // 4. 결과 확인
            if(resultCount > 0){
                System.out.println("삭제 완료!");
            } else {
                System.out.println("삭제 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultCount;
    }

    public static void main(String[] args) {
        DeleteTest3 deleteTest3 = new DeleteTest3();
        int resultCount = deleteTest3.deleteDept(80);
        System.out.println(resultCount);
    }
}
