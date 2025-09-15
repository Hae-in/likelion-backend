package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        // 0. 드라이버로딩 (mysql, oracle, ...) 드라이버를 메모리에 올려준다
        // Class.forName("com.mysql.jdbc.Driver"); // 요즘은 생략가능


        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";


        // 1. 접속 -- Connection
        Connection conn = DriverManager.getConnection(url, user, password); // connection 객체를 얻음

        // 2. 쿼리 작성 --  Statement, PreparedStatement, CallableStatement
        //     쿼리문이 실행 될때 DBMS가 알아들을 수 있게 번역(파싱) 된다.
        //     쿼리가 또 들어오면 이미 번역 한 것을 사용한다.
        //     insert into students(name) values ('kang');
        //     insert into students(name) values ('hong');
        //     insert into students(name) values ('kim');
        //     위의 쿼리는 각자 다른 쿼리로 인식
        //     Statement는 값까지 들어간 완벽한 쿼리로 실행된다. => 불필요한 자원 사용
        //           PreparedStatement: 전처리, 미리 컴파일된 SQL 구문을 실행하기 위해 사용, 바인딩 변수(?)를 통해 동적 파라미터를 안전하게 설정 가능.
        //     insert into student(name) values(?); -- 여기까지를 번역함
        // ⭐️PreparedStatement 쓰는 이유

        /**
         * Statement : 기본 SQL 실행 (주로 간단한 쿼리).
         * PreparedStatement : 파라미터 바인딩 + 성능 최적화.
         * CallableStatement : 프로시저 호출 전용.
         */

        // String sql = "insert into dept values(?,?,?)";
        String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        // 반드시 ?에 값을 채워줘야함
        ps.setInt(1, 80); // 해당 ? 번호
        ps.setString(2, "Like Lion");
        ps.setString(3, "Seoul");

        // 3. 실행
        int resultCount = ps.executeUpdate(); // int 리턴, delete, update 같이 한건 일 경우
        // ps.executeQuery(); //resultSet 객체 리턴, select 같이 여러건 일 경우

        /**
         * ps.executeUpdate()
         *   - 반환값: int — 영향받은 행(row) 수.
         *   - 용도: INSERT, UPDATE, DELETE 같은 DML에 주로 사용.
         *   - 예외/특이사항:
         *      - DDL(CREATE, ALTER, DROP)이나 일부 JDBC 드라이버에서는 0을 반환할 수 있다(영향받은 행이 없음).
         *      - 자동 증가 키가 필요하면 prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)로 생성하고 getGeneratedKeys() 사용.
         *
         * ps.executeQuery()
         *     반환값: ResultSet — 조회 결과(0개 이상 행).
         *     용도: SELECT 같은 쿼리(결과 집합을 반환하는 쿼리)에 사용.
         *     예외/특이사항:
         *        만약 INSERT/UPDATE/DELETE에 executeQuery()를 호출하면 SQLException이 발생한다(드라이버에 따라 예외 메시지 다름).
         *        결과가 0행이어도 ResultSet은 null이 아니라 빈 ResultSet을 반환하고 rs.next()가 false다.
         *
         * ps.execute()
         *     반환값: boolean — 첫 번째 결과가 ResultSet이면 true, 아니면 false.
         *     용도: 쿼리가 결과 집합 또는 update-count 중 무엇을 반환할지 모를 때(예: 저장 프로시저, 복합 쿼리).
         *     사용 예: 여러 결과(여러 ResultSet/update counts)를 처리해야 할 때 getMoreResults()/getUpdateCount()와 함께 사용.
         */

        if(resultCount == 1) {
            System.out.println("입력 성공!");
        } else {
            System.out.println("입력 실패!");
        }

        ps.close();
        conn.close();
    }
}
