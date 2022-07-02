package ProductRegisterDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.imageio.plugins.png.PNGMetadata;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

import Database.DatabaseLinker;
import ImageProcesser.ProductImageSaver;
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
			ProductImageSaver.saveImage(getProductImageMetadata());
			
			
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
		
		sql ="insert into product "
				+ "(product_number, product_name, product_description, product_register_date, product_image_metadata)"
				+ " values "
				+ "(product_number_seq.NEXTVAL,?,?,sysdate,product_number_seq.NEXTVAL)";
		
		psmt = connection.prepareStatement(sql);
		
		
		psmt.setString(1, productName);
		psmt.setString(2, productContent);
		
		
		
		int resultRow = psmt.executeUpdate();
		
		System.out.println("변경된 row : " + resultRow);
		
	}
	
	private String getProductImageMetadata() throws Exception{
		
		sql = "select product_image_metadata from product where product_number = (select max(product_number) from product)";
		
		psmt = connection.prepareStatement(sql);
		rs = psmt.executeQuery();
		 //DML(insert, update, delete) executeUpdate();
		 
		rs.next();
		return rs.getString(1);
	}

}

