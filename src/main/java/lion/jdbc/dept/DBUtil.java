package lion.jdbc.dept;

import java.sql.*;

public class DBUtil {
    // connetion 객체를 얻어 오는 기능
    // db 접속
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        return DriverManager.getConnection(url, user, password); // dao :try-catch, // 불러다쓰는쪽: throws, 하기나름
    }

    public Connection getConnection(String user, String password) {
        return null;
    }

    // public Connection getConnection(String url, String user, String password) {
    //     return null;
    // }

    // close는 열린 순서 반대로 닫아야함
    public static void close(Connection conn) {
        if(conn != null) {
            try{
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        if(pstmt != null) {
            try{
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn);
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(rs != null) {
            try{
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn, pstmt);
    }
}
