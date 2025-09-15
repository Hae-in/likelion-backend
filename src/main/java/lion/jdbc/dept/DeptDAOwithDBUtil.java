package lion.jdbc.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// 데이터베이스에 접근하는 역할만 담당하는 객체
public class DeptDAOwithDBUtil {
    public boolean insertDept(DeptDTO dto) {
        String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";

        boolean resultFlag = false;

        try (
             // getConnection()를 쓰기 위해서 굳이 객체를 생성할 필요가 있을까??
             // DBUtil은 따로 필드가 없기때문에 저장 공간 필요없음. -> 객체 생성 필요 없음. -> static (O)
             // 필드값이 있어서 생성될때마다 다른 값을 저장해야 하면 -> static (X)
             Connection conn = DBUtil.getConnection(); // ⭐️
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, dto.getDeptno());
            ps.setString(2, dto.getDname());
            ps.setString(3, dto.getLoc());

            int resultCount = ps.executeUpdate();

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

    public int deleteDept(int deptno) {
        String sql = "delete from dept where deptno = ?";

        int resultCount = 0;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, deptno); // deptno
            resultCount = ps.executeUpdate();

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

    public boolean updateDept(String dname, int deptno) {
        String sql = "update dept set dname = ? where deptno = ?";

        boolean resultFlag = false;

        try (
             Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, dname);
            ps.setInt(2, deptno);

            int resultCount = ps.executeUpdate();

            if(resultCount == 1) {
                resultFlag = true;
                System.out.println("수정 성공!");
            } else {
                System.out.println("수정 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultFlag;
    }

}
