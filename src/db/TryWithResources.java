package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResources {
	public static void main(String[] args) throws SQLException {
		// 연결 변수
		String id = "ADMIN";
		String pw = "pQ5Tf8q=k~$}";
		String url = "jdbc:oracle:thin:@vft_high?TNS_ADMIN=../wallet";

		// 실행 쿼리
		String sql = "select * from t_user";
		
		// 자바 7 버전
		try (Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);) {
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + " | " + rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=====================================");
		
		Connection conn = DriverManager.getConnection(url, id, pw);
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println(rs.getString(1) + " | " + rs.getString(2));
		}
	}
}
