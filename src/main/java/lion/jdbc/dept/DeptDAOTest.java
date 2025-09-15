package lion.jdbc.dept;

public class DeptDAOTest {
    public static void main(String[] args) {
        DeptDAO dao = new DeptDAO();
        dao.insertDept(60, "like", "일산");
        // dao.updateDept("like", 60);
        // dao.deleteDept(60);
    }
}
