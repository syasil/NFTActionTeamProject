package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection get() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//String id = "MSB";
			//String pw = "momo1004";
			//String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			
			String id = "ADMIN";
			String pw = "pQ5Tf8q=k~$}";
			String url = "jdbc:oracle:thin:@vft_high?TNS_ADMIN=../wallet";

			conn = DriverManager.getConnection(url, id, pw);
			//System.out.println("클라우드 디비 연결 성공");
		} catch (Exception e) {
			System.out.println("클라우드 디비 연결 실패");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
}
