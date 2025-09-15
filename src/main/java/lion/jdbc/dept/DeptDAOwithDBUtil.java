package lion.jdbc.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 데이터베이스에 접근하는 역할만 담당하는 객체
public class DeptDAOwithDBUtil {

    // 추가
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

    // 삭제
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

    // 수정
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

    // 조회
    public List<DeptDTO> selectAllDept() {
        List<DeptDTO> deptList = new ArrayList<DeptDTO>();

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
            // 한 번 지나온 rs는 다시 올라가지않음
            while (rs.next()) {
                // System.out.print(rs.getInt(1) + "\t");
                // System.out.print(rs.getString("dname") + "\t");
                // System.out.println(rs.getString(3));

                // sout 사용하지않고 List에 담음
                DeptDTO dto = new DeptDTO(); // 반복문 안에서 선언! ⭐️, 선언문 밖에서 생성되면??  가방 여러개를 만들어야하는데 가방을 하나만 만든 꼴(값 교체)
                dto.setDeptno(rs.getInt("deptno"));
                dto.setDname(rs.getString("dname"));
                dto.setLoc(rs.getString("loc"));
                deptList.add(dto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // 2. 선언했으면 닫아야함
            DBUtil.close(conn, ps, rs); // 닫는 순서: rs -> ps -> conn ⭐️
        }

        return deptList;
    }

}
