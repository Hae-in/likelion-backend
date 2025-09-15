package lion.jdbc.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// try-with-resource 없이 직접 close 하는 경우
public class DeptDAOwithClose {
    public int insert(DeptDTO dto) {
        int resultCount = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;


        // 로직이 복잡해지면 close() 하는 순서에따라 오류 발생할수도
        // 안전하게 쓸 필요가 있음 -> DBUtil에 close method들 생성 ⭐️= 직접 처리
        // try-with-resource = 컴파일러가 처리
        // close는 열린 순서 반대로 닫아야함
        try{
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("insert into dept (deptno, dname, loc) values(?,?,?)");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // if(pstmt != null) {
            //     try{
            //         pstmt.close();
            //     } catch (SQLException e) {
            //         throw new RuntimeException(e);
            //     }
            // }
            // if(conn != null) {
            //     try{
            //         conn.close();
            //     } catch (SQLException e) {
            //         throw new RuntimeException(e);
            //     }
            // }

            // 한 줄로 해결! ⭐️
            DBUtil.close(conn, pstmt);
        }
        return resultCount;
    }
}
