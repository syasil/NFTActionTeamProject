package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SampleC {
	public static void main(String[] args) throws SQLException {
		Connection conn = null; // DB와 연결하는 인터페이스
		PreparedStatement psmt = null; // sql 문 객체
		ResultSet rs = null; // sql에 대한 반환(쿼리 실행에 대한 결과값 저장 
		
		
		try {
			String que = "select * from sample";

			conn = DB.getC(); // DB연결
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String col1 = rs.getString(1);
				String col2 = rs.getString(2);
				String col3 = rs.getString(3);
				String col4 = rs.getString(4);
				System.out.println(col1 + " | " + col2 + "\t| " + col3 + "\t| " + col4 + "\t|" + rs.getString(5));
			}
			
			
			rs.close(); 
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
