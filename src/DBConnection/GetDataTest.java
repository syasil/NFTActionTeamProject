package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetDataTest {

	public String todayAuc = getTodayAUC();
	
	public String getTodayAUC() {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			String que = "SELECT COUNT(*) FROM AUCTION WHERE SUBSTR(TO_CHAR(AUC_END), 1, 10) = TO_CHAR(SYSDATE)";
			
			//DB 연결
			conn = JdbcUtil.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			System.out.println(que);
			while(rs.next()) {
				todayAuc = rs.getString(1);
				System.out.println("getTodayAUC():"+ todayAuc);
			}
			
			return todayAuc;
			/*
			 * rs.close(); psmt.close(); conn.close();
			 */
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
