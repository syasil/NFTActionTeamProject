package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class GetData {
	
	static JdbcUtil dbConn = new JdbcUtil();
	private DefaultTableModel modelAuc;
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String que = null;

	// 오늘 시작된 경매 건수
	public String todayAuc = getTodayAUC();
	public String getTodayAUC() {
		
		try {
			que = "SELECT COUNT(*) FROM AUCTION WHERE SUBSTR(TO_CHAR(AUC_START), 1, 10) = TO_CHAR(SYSDATE)";
			
			//DB 연결
			conn = JdbcUtil.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			System.out.println(que);
			while(rs.next()) {
				todayAuc = rs.getString(1);
			}
			
			return todayAuc;
			/* rs.close(); psmt.close(); conn.close(); */
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	// 오늘 시작된 경매 금액
	public String todayAucPrice = getTodayAucPrice();
	public String getTodayAucPrice() {
		
		try {
			que = "SELECT sum(AUC_LPRICE) FROM AUCTION WHERE SUBSTR(TO_CHAR(AUC_START), 1, 10) = TO_CHAR(SYSDATE)";
			
			//DB 연결
			conn = JdbcUtil.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			System.out.println(que);
			while(rs.next()) {
				todayAucPrice = rs.getString(1);
			}
			
			return todayAucPrice;
			/* rs.close(); psmt.close(); conn.close(); */
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	
	
	
}
