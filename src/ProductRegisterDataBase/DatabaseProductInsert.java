package ProductRegisterDataBase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.imageio.plugins.png.PNGMetadata;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

import Database.DatabaseLinker;
import ImageProcesser.ImageFileSaver;
import ProductRegisterPage.ProductRegisterContentTextField;
import ProductRegisterPage.ProductRegisterImageLabel;
import ProductRegisterPage.ProductRegisterNameTextField;
import main.Main;
import user.proc.LoginProc;

public class DatabaseProductInsert {
	DatabaseLinker databaseLinker = new DatabaseLinker();

	Connection connection; 
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	String productName;
	String productContent;
	File productImage;
	
	String sql;

	private FileInputStream image;
	
	public void dataInsert() {
		try {
			
			getData();
			connection = databaseLinker.connectDB();
			postData();
			//ImageFileSaver.saveImage(getProductImageMetadata());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
	}
	private void getData() throws Exception{
		
		productName = ProductRegisterNameTextField.getTextFieldValue();
		productContent = ProductRegisterContentTextField.getTextFieldValue();
		productImage = ImageFileSaver.getFile();
		
		
		
		
	}
	private void postData() throws SQLException, Exception{
		
		sql ="insert into t_product "
				+ "(PRO_NO, USER_NO, PRO_NAME, PRO_REGDAY, PRO_EXP, PRO_IMG)"
				+ " values "
				+ "(SEQ_T_PRO_NO.NEXTVAL, ?, ?, sysdate, ?, ?)";
		
		psmt = connection.prepareStatement(sql);
		
		psmt.setString(1, Main.USER_NO);
		psmt.setString(2, productName);
		psmt.setString(3, productContent);
		psmt.setBlob(4,new FileInputStream(productImage));
		
		
		
		
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

