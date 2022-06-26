import java.sql.Connection;
import java.sql.DriverManager;

public class connecDb {

	public static Connection get() {
		Connection conn=null;
		
		try {
			
			String id="JYY";
			String pw="@Tt38003800";
			String url="jdbc:oracle:thin:@localhost:1521/xepdb1";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			conn=DriverManager.getConnection(url,id,pw);
		
			
			System.out.println("입력완료");
		}catch(Exception e) {
			System.out.println("문제");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
