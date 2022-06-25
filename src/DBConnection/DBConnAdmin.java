package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnAdmin {
	
	JdbcUtil dbConn = new JdbcUtil();
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;	
	
	//db 에서 가져올 값들
	int pd_no;
	String pd_name;
	String pd_desc;
	int pd_price;		//상품값 기본 null 설정
	int pd_reg_user;
	java.sql.Date pd_reg_date;
	
	String que;
	
	//DB 값 가져오기 - select
	public void getData() throws SQLException {
		try {
			que = "SELECT * FROM PRODUCT_B ";

			//DB 연결
			conn = dbConn.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				pd_no = rs.getInt(1);
				pd_name = rs.getString(2);
				pd_desc = rs.getString(3);
				pd_price = rs.getInt(4);
				pd_reg_user = rs.getInt(5);
				pd_reg_date = rs.getDate(6);
				
//				psmt.setInt(1, pd_no); 
//				psmt.setString(2, pd_name); 
//				psmt.setString(3, pd_desc); 
//				psmt.setInt(4, pd_price); 
//				psmt.setInt(5, pd_reg_user);
//				psmt.setDate(6, pd_reg_date);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		psmt.close();
		conn.close();
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
