import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Img extends JFrame{
	Img(){
	JFrame a= new JFrame();
	JLabel lblID = new JLabel();
	getContentPane();
	a.add(lblID);
	setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new Img();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String que = "select * from user_t";

			conn = connecDb.get();

			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			String id=null;
			while (rs.next()) {

				id = rs.getString(7);
				  
			      
			}
			BufferedImage buffered_image= ImageIO.read(new File(id));
		      ByteArrayOutputStream output_stream= new ByteArrayOutputStream();
		      ImageIO.write(buffered_image, "jpg", output_stream);
		      byte [] byte_array = output_stream.toByteArray();
		      ByteArrayInputStream input_stream= new ByteArrayInputStream(byte_array);
		      BufferedImage final_buffered_image = ImageIO.read(input_stream);
		      ImageIO.write(final_buffered_image , "jpg", new File("final_file.jpg") );
		      System.out.println("Converted Successfully!");	
		    
				
				rs.close();
				psmt.close();
				conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		
		
	    /*    try {
	        	binar fis2=new FileInputStream(NewUser.fis);
	        	byte b[] = new byte[100];
	        	int n=0, c;
	            while((c=fis2.read()) != -1 ) {
	                b[n] = (byte)c; //읽은 바이트를 배열에 저장
	                n++;
	            }
	            // 배열 b의 바이트 값을 모두 화면에 출력
	            for(int i=0; i<b.length; i++)
	                System.out.print(b[i] + " ");
	            
	            fis2.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
    }
}
