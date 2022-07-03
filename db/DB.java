package db;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class DB {

	public static Connection get() {
		Connection conn = null;
		
		try {
			String id = "Three_Team";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			
			// JDBC 드라이버를 로딩하는 코드 => DriverManager에 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			// System.out.println("데이터베이스에 연결되었다.");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("로딩 실패");
		}
		
		return conn;
	}
}