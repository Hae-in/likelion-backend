package lion.jdbc.dept;

import java.util.List;

public class DeptDAOTest {
    public static void main(String[] args) {
        DeptDAO dao = new DeptDAO();
        DeptDTO dto = new DeptDTO();

        // 추가
        // dao.insertDept(60, "like", "일산");

        // 추가
        // dto.setDeptno(60);
        // dto.setDname("like");
        // dto.setLoc("일산");
        //
        // boolean result = dao.insertDept(dto);
        // System.out.println(result);

        // 수정
        // dao.updateDept("like", 60);

        // 삭제
        // dao.deleteDept(60);

        // 조회
        DeptDAOwithDBUtil deptDAO = new DeptDAOwithDBUtil();
        List<DeptDTO> deptList = deptDAO.selectAllDept();

        for (DeptDTO deptDTO : deptList) {
            System.out.println(deptDTO);
        }
    }
}
