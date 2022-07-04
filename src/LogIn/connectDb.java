package LogIn;

import java.sql.Connection;
import java.sql.DriverManager;

import Database.DatabaseLinker;

public class connectDb {

	public static connectDb instance = new connectDb();
	private connectDb() {}
	public static connectDb getInstance() {
		return instance;
	}
	
	Connection conn = null;
	
	public Connection get() {
		
		
		try {

			String id = "JYY";
			String pw = "@Tt38003800";
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, id, pw);

			System.out.println("입력완료");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return conn;
	}

}
