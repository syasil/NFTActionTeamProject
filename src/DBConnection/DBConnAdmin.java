package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnAdmin {
	
	static JdbcUtil dbConn = new JdbcUtil();
	
	//db 에서 가져올 값들
	static int pd_no;
	static String pd_name;
	static String pd_desc;
	static int pd_reg_user;
	static java.sql.Date pd_reg_date;
	
	static String que;
	
	//DB 값 가져오기 - select
	public static String[][] getPdList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			que = "SELECT PRODUCT_NUMBER, PRODUCT_NAME, PRODUCT_DESCRIPTION, "
					+ "PRODUCT_PRICE, PRODUCT_REGISTER_USER, "
					+ "PRODUCT_REGISTER_DATE "
					+ "FROM PRODUCT_B ";

			//DB 연결
			conn = dbConn.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			//반환값 저장
			ArrayList<String[]> pdlist = new ArrayList<String[]>(); 
			
			while(rs.next()) {
				pdlist.add (new String[] {
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
				});
			}
			System.out.println("DBConnAdmin: 데이터 가져오기 성공");
			String[][] arr = new String[pdlist.size()][6];
			return pdlist.toArray(arr);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		/*
		 * rs.close(); psmt.close(); conn.close();
		 */
	}
}
