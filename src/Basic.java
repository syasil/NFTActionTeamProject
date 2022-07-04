import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import admin.AdminMainPage;
import blockchain.BlockChain;
import socket.Client;
import swing.CButton;
import swing.CLabel;
import swing.CPanel;
import swing.CPasswordField;
import swing.CTextField;

public class Basic extends JFrame{
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public static String userNo = "";
	public static String userID = "";
	public static String userPw = "";
	public static String userBirth = "";
	public static String userNick = "";
	public static int userPoint = 0;
	public static ImageIcon userIcon = null;

	
	private CPasswordField txtfPw;
	private Blob blob;
	private ImageIcon icon;
	private Image image;
	private CPanel pnlBefore;
	private CLabel lblID;
	private CLabel lblPw;
	private CTextField txtfID;
	private CButton bntlogIn;
	private CButton bntSign;
	private CButton bntMissing;
	private CLabel lblTitle;
	private String pw;
	private Thread blockChainThread;
	private InputStream inputStream;
	private int bytesRead;
	private byte[] buffer;

	public static Basic instance;
	
	/**
	 * Launch the application.11
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instance = new Basic();
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
	public Basic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		initNet();
		BlockChain blockChain = new BlockChain();
		Thread blockChainThread = new Thread(blockChain);
		blockChainThread.start();
		setSize(600, 900);

		pnlBefore = new CPanel();
		lblID = new CLabel("ID: ");
		lblPw = new CLabel("PW:");
		txtfID = new CTextField(10);
		txtfPw = new CPasswordField(10);
		bntlogIn = new CButton("로그인");
		bntSign = new CButton("회원가입");
		bntMissing = new CButton("ID / PW찾기");
		bntMissing.setText("ID/PW찾기");
		lblTitle = new CLabel("NFT 경매 시스템");

		// ***********좌표 설정***************
		pnlBefore.setLayout(null);
		lblID.setBounds(345, 25, 30, 30);
		txtfID.setBounds(377, 25, 100, 30);
		lblPw.setBounds(345, 60, 30, 30);
		bntlogIn.setBounds(480, 15, 100, 80);
		txtfPw.setBounds(377, 60, 100, 30);
		bntSign.setBounds(345, 100, 108, 20);
		bntMissing.setBounds(455, 100, 125, 20);
		lblTitle.setBounds(12, -10, 336, 155);

		// ************색상********************
		bntlogIn.setBackground(Color.LIGHT_GRAY);
		bntSign.setBackground(Color.LIGHT_GRAY);
		bntMissing.setBackground(Color.LIGHT_GRAY);

		// *************폰트*********************
		// Font font = new Font("맑은 고딕", Font.ITALIC, 40);
		lblTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 40));

		// ***********add*******************
		getContentPane().add(pnlBefore);
		pnlBefore.add(lblID);
		pnlBefore.add(txtfID);
		pnlBefore.add(lblPw);
		pnlBefore.add(txtfPw);
		pnlBefore.add(bntlogIn);
		pnlBefore.add(bntSign);
		pnlBefore.add(bntMissing);
		pnlBefore.add(lblTitle);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// ***********기능*********
		bntSign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewUser();
			}
		});
		// ---------------------------------------------------
		bntMissing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MissingID();

			}
		});
		// ---------------------------------------------------
		bntlogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {

			
					String que = "select * from t_user natural join t_wallet where user_id= ? ";//sql 

					conn = connectDb.getInstance().get(); // 커넥션 객체를 호출합니다.
					
					psmt = conn.prepareStatement(que);
					psmt.setString(1, txtfID.getText());
					
					rs = psmt.executeQuery();

					if (rs.next()) {
						
						PasswordCheck();
						
					} else {
						
						JOptionPane.showMessageDialog(null, "등록된 " + txtfID.getText() + "가 없습니다.");

					}
				
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
	}

	private void initNet() {
		
		Client clientSocket = new Client();
		try {
			
			clientSocket.ConnectSocketServer();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

	private void LogIn() throws SQLException, Exception {
		
		
		userNo = rs.getString("user_no");
		userID = rs.getString("user_id");
		userBirth = rs.getString("user_bir");
		userNick = rs.getString("user_nick");
		userPoint = rs.getInt("wal_amount");
		blob = rs.getBlob("user_icon"); // 이미지파일 불러오는중
		inputStream = blob.getBinaryStream();
		
		bytesRead = -1;
		buffer = new byte[4096];
		
		icon = new ImageIcon(blob.getBytes(1, (int) blob.length()), "description"); // 이미지 불러옴
		image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 크기조절 후 이미지에 넣기
		userIcon = new ImageIcon(image); // ImageIcon에 조절된 이지 넣기

		
		
		if (userID.equals("vft")) { //유저 아이디가 vft 관리자일경우 
			
			new AdminMainPage().setVisible(true);  //관리자 페이지 생성
			
		} else {
			
			textFieldClear(); //텍스트 필드 지우기
			LogIn.getInstance().setVisible(true);//유저 페이지 생성
			
		}
		setVisible(false);
		
	}
	
	
	private void textFieldClear() {

		txtfID.setText("");
		txtfPw.setText("");
		
	}

	private void PasswordCheck() throws SQLException, Exception {
		
		pw = rs.getString("user_pass"); // 패스워드 데이터 가져오기
		
		if (txtfPw.getText().equals(pw)) {
				
			LogIn();
			
		} else {
			
			JOptionPane.showMessageDialog(null, "비밀번호가 잘못되었습니다.");
		
		}
		
	}
	public static JFrame getInstance() {
		
		return instance;
		
	}
	

}

