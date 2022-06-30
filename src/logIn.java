import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class logIn extends JFrame {
//	JLabel lblImg;
	private JFrame frameAfter;
	private int point;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn window = new logIn();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logIn() {
		initialize();
	//	getUserInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameAfter = new JFrame();

		frameAfter.setSize(600, 900);

		JPanel pnlAfter = new JPanel();

		JButton bntlogOut = new JButton("로그아웃");
		JLabel lblTitle = new JLabel("NFT 경매 시스템");
		JLabel lblWelcome = new JLabel("환영합니다");
		JLabel lblUserID = new JLabel(Basic.userID + " 님");
		JLabel lblPoint = new JLabel("포인트 : " +Basic.userPoint);
		JLabel lblImg = new JLabel(Basic.userIcon);
		frameAfter.setVisible(false);

		pnlAfter.setLayout(null);

		// ***********좌표 설정***************

		lblWelcome.setBounds(474, 10, 100, 28);
		lblUserID.setBounds(474, 34, 100, 28);
		lblImg.setBounds(360, 27, 100, 100);
		bntlogOut.setBounds(474, 96, 100, 20);
		lblTitle.setBounds(12, -10, 336, 155);
		lblPoint.setBounds(474, 61, 100, 28);
		// *************폰트*********************
		Font font = new Font("궁서", Font.ITALIC, 40);
		bntlogOut.setBackground(Color.LIGHT_GRAY);
		lblTitle.setFont(font);

		// ***********add*******************
		frameAfter.getContentPane().add(pnlAfter);
		pnlAfter.add(lblTitle);
		pnlAfter.add(bntlogOut);
		pnlAfter.add(lblWelcome);
		pnlAfter.add(lblUserID);
		pnlAfter.add(lblImg);
		pnlAfter.add(lblPoint);

		// ************기능********************
		bntlogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameAfter.setVisible(false);
				Basic.userNo = "";
				Basic.userID = "";
				Basic.userNick = "";
				Basic.userPoint = 0;
				Basic.userIcon = null;
				Basic.userBirth="";
				Basic.userPw="";
				new Basic().setVisible(true);
			}
		});

	}



	public void setVisible(boolean b) {
		frameAfter.setVisible(b);
	}
}


//----------------------------------------------------------------------------------------------삭제예정 확인중
//public void getUserInfo() {
//Connection conn = null;
//PreparedStatement psmt = null;
//ResultSet rs = null;
//
//try {
//	
////	String que = "select * from user_t where user_id='" + txtfID.getText() + "'";
//	String que = "select * from user_t,point where user_id='" + Basic.userID + "'";
//	//String que = "select user_t.user_no,user_t.user_id,user_t.user_pass,user_t.user_bir,user_t.user_nick,user_t.user_icon,point.pnt_total from user_t left outer join point on user_id='" + txtfID.getText() + "'";
//	
//	
//	conn = connecDb.get();
//
//	psmt = conn.prepareStatement(que);
//	rs = psmt.executeQuery();
//	
//	
//	if (rs.next()) {
//	//InputStream asd=rs.getBinaryStream(7);
//		
//		
////		
////		String no = rs.getString(1);
////		String id = rs.getString(2);
////		String pw = rs.getString(3);
////		String birth = rs.getString(4);
////		String nick = rs.getString(5);
//		//String icon = rs.getString(6);	-> blob파일 읽어와야함  실현못함
//		int point = rs.getInt(10);
//		
//		Blob blob = rs.getBlob("user_icon");
//		InputStream inputStream = blob.getBinaryStream();
//		//OutputStream outputStream =new FileOutputStream(Filepath);
//		
//		int bytesRead = -1;
//		byte[] buffer = new byte[4096];
////		while ((bytesRead = inputStream.read(buffer)) != -1) 
//	//	{	
//		//	outputStream.write(buffer,0, bytesRead);
//			//}
//	
//		inputStream.close();
//		
//		ImageIcon icon=new ImageIcon(blob.getBytes(1, (int) blob.length()),"description");  //이미지 불러옴
//		Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 크기조절 후 이미지에 넣기
//		ImageIcon icon2 = new ImageIcon(image); // ImageIcon에 조절된 이지 넣기
//		lblImg.setIcon(icon2);
//		//String icon = rs.getString(6);	-> blob파일 읽어와야함  실현못함
//		//int point = rs.getInt(10);
//		//ImageIcon icon=new ImageIcon(OutputStream);
////		Basic.userNo = no;
////		Basic.userID = id;
////		Basic.userNick = nick;
//		
////		Basic.userBirth=birth;
////		Basic.userPw=pw;
//	}
//
//	rs.close();
//	psmt.close();
//	conn.close();
//} catch (Exception e1) {
//	e1.getStackTrace();
//}
//}