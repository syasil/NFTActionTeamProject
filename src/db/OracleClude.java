package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OracleClude {
	public static void main(String[] args) throws SQLException {
		Connection conn = null; // DB와 연결하는 인터페이스
		PreparedStatement psmt = null; // sql 문 객체
		ResultSet rs = null; // sql에 대한 반환(쿼리 실행에 대한 결과값 저장 
		
		
		try {
			String que = "select * from sample";

			conn = DB.get(); // DB연결
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int s_no = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString("email");
				Date create_date = rs.getDate("create_date");
				
				int sal = rs.getInt("sal");
				int comm = rs.getInt("COMM");
				System.out.println(s_no + " | " + name + "\t| " + email + "\t| " + create_date + "\t|" + rs.getDate("edit_date"));
			}
			
			
			rs.close(); 
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
