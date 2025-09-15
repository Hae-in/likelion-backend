package lion.jdbc.dept;

import java.sql.Connection;
import java.sql.DriverManager;
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

}
