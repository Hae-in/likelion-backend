package lion.jdbc.dept;

public class DeptDAOTest {
    public static void main(String[] args) {
        DeptDAO dao = new DeptDAO();
        DeptDTO dto = new DeptDTO();

        // dao.insertDept(60, "like", "일산");

        dto.setDeptno(60);
        dto.setDname("like");
        dto.setLoc("일산");

        // dao.updateDept("like", 60);
        // dao.deleteDept(60);

        boolean result = dao.insertDept(dto);
        System.out.println(result);

    }
}
