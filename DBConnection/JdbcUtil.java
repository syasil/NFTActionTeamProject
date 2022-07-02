package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	// 데이터 베이스 연결
	public static Connection con;
	
	public static Connection getConnection() {
		Connection conn = null;
		
		//연결
		try {
			String id = "BM";
			String pw= "bm0301";
			String url="jdbc:oracle:thin:@localhost:1521/xepdb1";
			
			//jdbc 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB 연결 성공");
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
		}
		return conn;
		
	}
}
