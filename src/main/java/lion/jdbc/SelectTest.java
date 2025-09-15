package lion.jdbc;

import lion.jdbc.dept.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
    public static void main(String[] args) {

        // 1. 필요한 객체를 먼저 선언
        Connection conn = null;
        PreparedStatement ps = null; // 명령 수행
        ResultSet rs = null; // sql 실행 결과 추상화

        String sql = "select deptno, dname, loc from dept"; // * 보다 컬럼명으로 졍확하게 표현

        try {
            // 3. connection
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // 지금 rs(쿼리의 결과)는 누가 가지고있나?? DBMS ⭐️
            // 왜 executeQuery() 하자마자 결과를 안 넘겨주고 들고 있을까?? 데이터가 많을 경우, 프로그램은 아무일도 못하고 멈춰 있음
            // 전체를 가리키는 것: 커서
            // next()를 싱행해야 첫 번째 row를 가리키는 곳으로 이동. => true/false 리턴, 다음 row로 이동

            // 데이터를 하나씩 꺼내옴
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString("dname") + "\t");
                System.out.println(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // 2. 선언했으면 닫아야함
            DBUtil.close(conn, ps, rs); // 닫는 순서: rs -> ps -> conn ⭐️
        }
    }
}
