import java.sql.Connection;
import java.sql.DriverManager;

public class connecDb {

	public static Connection get() {
		Connection conn = null;
		/*
		create table test1 (
			NO NUMBER(3),
			ID VARCHAR2(20),
			PW NUMBER(10),
			BIRTH DATE,
			NICK VARCHAR2(20));*/
		//테스트용 테이블
		try {

			String id = "JYY";
			String pw = "@Tt38003800";
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, id, pw);

			System.out.println("입력완료");
		} catch (Exception e) {
			System.out.println("문제");
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
