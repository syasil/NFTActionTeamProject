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
	static int pd_price;		//상품값 기본 null 설정
	static int pd_reg_user;
	static java.sql.Date pd_reg_date;
	
	static String que;
	
	//DB 값 가져오기 - select
	public static String[][] getPdList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
//			que = "SELECT * FROM PRODUCT_B ";
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
//				pd_no = rs.getInt(1);
//				pd_name = rs.getString(2);
//				pd_desc = rs.getString(3);
//				pd_price = rs.getInt(4);
//				pd_reg_user = rs.getInt(5);
//				pd_reg_date = rs.getDate(6);
			}
			System.out.println("DBConnAdmin: 데이터 가져오기 성공");
			String[][] arr = new String[pdlist.size()][6];
			return pdlist.toArray(arr);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
//		rs.close();
//		psmt.close();
//		conn.close();
	}
	
	
	/*
	public static void main(String[] args) throws SQLException {
		// DB에 연결해서 상품 목록을 가져온다

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			String que = "SELECT * FROM PRODUCT_B ";
			
			//DB 연결
			conn = DBConn.get();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//DB 값 가져오기
				int pd_no = rs.getInt(1);
				String pd_name = rs.getString(2);
				String pd_desc = rs.getString(3);
				//상품값 기본 null 설정
				int pd_price = rs.getInt(4);
				int pd_reg_user = rs.getInt(5);
				java.sql.Date pd_reg_date = rs.getDate(6);
				
				System.out.println(
						pd_no+" "+
								pd_name+" "+
								pd_desc+" "+
								pd_price+" "+
								pd_reg_user+" "+
								pd_reg_date
				);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		psmt.close();
		conn.close();
		
	}
	*/
	
}
