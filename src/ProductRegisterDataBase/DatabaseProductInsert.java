package ProductRegisterDataBase;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.DatabaseLinker;
import ImageProcesser.ImageFileSaver;
import ProductRegisterPage.ProductRegisterContentTextField;
import ProductRegisterPage.ProductRegisterNameTextField;
import main.Main;


public class DatabaseProductInsert {


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
			connection = DatabaseLinker.getInstance().connectDB();
			postData();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
	}
	
	//각 textFiled에서 정보를 가져옴
	private void getData() throws Exception{
		
		productName = ProductRegisterNameTextField.getTextFieldValue();
		productContent = ProductRegisterContentTextField.getTextFieldValue();
		productImage = ImageFileSaver.getFile();
		
		
		
		
	}
	
	//t_product에 정보를 입력
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
	
}

