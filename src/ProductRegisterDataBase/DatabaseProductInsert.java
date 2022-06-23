package ProductRegisterDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import Database.DatabaseLinker;
import ProductRegisterPage.ProductRegisterContentTextField;
import ProductRegisterPage.ProductRegisterImageLabel;
import ProductRegisterPage.ProductRegisterNameTextField;

public class DatabaseProductInsert {
	DatabaseLinker databaseLinker = new DatabaseLinker();

	Connection connection; 
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	String productName;
	String productContent;
	ImageIcon productImage;
	
	String sql;
	
	public void dataInsert() {
		try {
			
			getData();
			connection = databaseLinker.connectDB();
			postData();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	private void getData() throws Exception{
		
		productName = ProductRegisterNameTextField.getTextFieldValue();
		productContent = ProductRegisterContentTextField.getTextFieldValue();
		productImage = ProductRegisterImageLabel.getImage();
			
		
	}
	private void postData() throws SQLException, Exception{
		
		sql ="insert into product (product_name, product_description) values (?,?)";
		
		psmt = connection.prepareStatement(sql);
		
		System.out.println(sql);
		
		psmt.setString(1, productName);
		psmt.setString(2, productContent);
		
		int resultRow = psmt.executeUpdate();
		
		System.out.println("변경된 row : " + resultRow);
		
	}
	
	
}
