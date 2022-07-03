package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuctionEndProductInsert {
	
	Connection connection = null; 
	PreparedStatement psmt = null;
	ResultSet rs = null;
	private String sql;
	private String pro_name;
	private String auc_log_no;
	private String auc_log_date;
	private String hash;
	private String Product_no;
	private String price;
	private String User_no;
	private String is_auc_success;
	
	
	public AuctionEndProductInsert() {
		 
		DatabaseLinker databaseLinker = new  DatabaseLinker();
		try {
			
			connection = databaseLinker.connectDB();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	public void setData(String Product_no, String price, String User_no) {
			
			this.Product_no = Product_no;
			this.price = price;
			this.User_no = User_no;
	}
	
	public void getData() {
		
		try {
			
			sql ="select auc_log_no, auc_log_date "
					+ "from t_auction_log "
					+ "where  auc_log_no = (select max(auc_log_no) from t_auction_log)";
			psmt = connection.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			
			rs.next();
			auc_log_no = rs.getString(1);
			auc_log_date = rs.getString(2);
			
			
			
			
			sql ="select pro_name from t_product where pro_no = ?";
			
			psmt = connection.prepareStatement(sql);
			
			psmt.setString(1, Product_no);
			
			rs = psmt.executeQuery();
			
			rs.next();
			pro_name = rs.getString("pro_name");
			

		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void postProduct() {
		
		try {
			
			sql ="insert into t_auction_log VALUES (SEQ_T_AUC_LOG_NO.nextval, SEQ_T_AUC_LOG_NO.nextval, ?, ?, ?, sysdate,?)";
			psmt = connection.prepareStatement(sql);
			
			System.out.println("insert auction_log ;");
			
			System.out.println("1 : " + User_no);
			System.out.println("2 : " + price);
			System.out.println("3 : " + (is_auc_success = !User_no.equals("0") ? "Y": "N")); //0 = 관리자,  0 이 아니면 누군가 입찰한 것
			System.out.println("4 : " + Product_no);
			
			
			psmt.setString(1, User_no);
			psmt.setString(2, price);
			psmt.setString(3, is_auc_success);
			psmt.setString(4, Product_no);
			

			int resultRow = psmt.executeUpdate();
			
			System.out.println("변경된 row : " + resultRow);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	public void postBlock(){

		try {
			
			sql ="insert into t_blocks VALUES (?, ?, ?, ?, to_date((?), 'YYYY-MM-DD HH24:MI:SS'), 1, ?, sysdate)";
			psmt = connection.prepareStatement(sql);
			
			System.out.println("insert block ;");
			System.out.println("1 : " + User_no);
			System.out.println("2 : " + Product_no);
			System.out.println("3 : " + pro_name);
			System.out.println("4 : " + auc_log_no);
			System.out.println("5 : " + auc_log_date);
			
			psmt.setString(1, User_no);
			psmt.setString(2, Product_no);
			psmt.setString(3, pro_name);
			psmt.setString(4, auc_log_no);
			psmt.setString(5, auc_log_date);
			
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				md.update(auc_log_no.getBytes());
				hash = String.format("%064x", new BigInteger(1, md.digest()));
				
				System.out.println("6 : " + hash);
				psmt.setString(6, hash);
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			int resultRow = psmt.executeUpdate();
			
			System.out.println("변경된 row : " + resultRow);
			
			
		} catch (SQLException e) {
			
		
			e.printStackTrace();
			
		}
		
		
		//psmt.setString();

	}
	

}
