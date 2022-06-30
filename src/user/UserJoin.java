package user;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import db.DB;
import functions.ResizeImage;
import main.Main;
import swing.CButton;
import swing.CImageButton;
import swing.CLabel;
import swing.CPanel;
import swing.CPasswordField;
import swing.CTextField;

public class UserJoin extends CPanel {
	private CPanel instance;
	private CTextField txtUserID;
	private CPasswordField txtUserPW;
	private CPasswordField txtUserPW_Re;
	private CTextField txtUserNickname;
	private CTextField txtUserWallet;
	private File selectedFile;

	public UserJoin() {
		super(30);
		this.instance = this;
		initComponents();
	}
	
	private void initComponents() {

		/////////////////////////
		// 패널 기본 설정
		/////////////////////////
		setBounds(100, 0, 400, 662);

		
		//////////////////////////////////
		// 패널 닫기
		//////////////////////////////////
		CLabel lblClose = new CLabel("×", 40);
		lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblClose.setBounds(358, 12, 30, 30);
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				instance.setVisible(false);
			}
		});
		add(lblClose);

		
		/////////////////////////
		// 타이틀
		/////////////////////////
		CLabel lblTitle = new CLabel("회원가입", 28);
		lblTitle.setBounds(25, 26, 174, 50);
		add(lblTitle);


		/////////////////////////
		// 아이디
		/////////////////////////
		CLabel lblID = new CLabel("아이디 (이메일)");
		lblID.setBounds(25, 94, 347, 30);
		add(lblID);
		
		txtUserID = new CTextField();
		txtUserID.setBounds(25, 130, 226, 40);
		add(txtUserID);
		
		CButton btnVerifyID = new CButton("중복확인", "DARK");
		btnVerifyID.setBounds(257, 136, 115, 25);
		add(btnVerifyID);


		/////////////////////////
		// 비밀번호, 비밀번호 확인
		/////////////////////////
		CLabel lblPW = new CLabel("비밀번호");
		lblPW.setBounds(25, 180, 174, 30);
		add(lblPW);
		
		txtUserPW = new CPasswordField();
		txtUserPW.setBounds(25, 213, 170, 40);
		add(txtUserPW);
		
		CLabel lblPWCheck = new CLabel("비밀번호 확인");
		lblPWCheck.setBounds(202, 180, 170, 30);
		add(lblPWCheck);
		
		txtUserPW_Re = new CPasswordField();
		txtUserPW_Re.setBounds(202, 213, 170, 40);
		add(txtUserPW_Re);
		

		/////////////////////////
		// 닉네임
		/////////////////////////
		CLabel lblNickname = new CLabel("닉네임");
		lblNickname.setBounds(25, 263, 347, 30);
		add(lblNickname);
		
		txtUserNickname = new CTextField();
		txtUserNickname.setBounds(25, 292, 347, 40);
		add(txtUserNickname);

		
		/////////////////////////
		// 전자 지갑
		/////////////////////////
		CLabel lblWallet = new CLabel("전자지갑 번호");
		lblWallet.setBounds(25, 342, 347, 30);
		add(lblWallet);
		
		txtUserWallet = new CTextField();
		txtUserWallet.setBounds(25, 374, 226, 40);
		add(txtUserWallet);
		
		CButton btnVerifyWallet = new CButton("인증하기", "DARK");
		btnVerifyWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), txtUserWallet.getText() + "전자지갑 인층 처리");
			}
		});
		btnVerifyWallet.setBounds(257, 382, 115, 25);
		add(btnVerifyWallet);

		
		//////////////////////////////////
		// 프로필 사진
		//////////////////////////////////
		CLabel lblProfilePic = new CLabel("프로필 사진");
		lblProfilePic.setBounds(227, 485, 101, 30);
		add(lblProfilePic);
		
		ImageIcon img = ResizeImage.resize("images/profile.jpg", 130, 130);
		CImageButton btnProfile = new CImageButton(img, 130);
		btnProfile.setBounds(55, 441, 130, 130);
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				FileFilter imageFilter = new FileNameExtensionFilter("이미지 파일", ImageIO.getReaderFileSuffixes());
				fileChooser.setFileFilter(imageFilter);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(getParent());
				
				if (result == JFileChooser.APPROVE_OPTION) {
					//선택한 파일의 경로 반환
					selectedFile = fileChooser.getSelectedFile();
					
					ImageIcon imgFile = ResizeImage.resize(selectedFile.toString(), 130, 130); 
					btnProfile.setImage(imgFile);
				}
			}
		});
		add(btnProfile);

		
		//////////////////////////////////
		// 가입하기 버튼
		//////////////////////////////////
		CButton btnJoin = new CButton("가입하기");
		btnJoin.setBounds(25, 594, 347, 40);
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				
				
				try {
					String sql = "INSERT INTO USERS (USER_NO, USER_ID, USER_PASS, USER_NICK, USER_WALLET, USER_ICON, USER_CREDAY)"
						+ " values (seq_users.nextval, ?, ?, ?, ?, ?, SYSDATE)";

					conn = DB.get(); // DB연결
					psmt = conn.prepareStatement(sql);

					
					psmt.setString(1, txtUserID.getText());
					psmt.setString(2, new String(txtUserPW.getPassword()));
					psmt.setString(3, txtUserNickname.getText());
					psmt.setString(4, txtUserWallet.getText());

					FileInputStream fis = new FileInputStream(selectedFile);

					psmt.setBinaryStream(5, fis,(int)selectedFile.length());
					int result = psmt.executeUpdate();
					
					if(result > 0){
						System.out.println("삽입성공");
					}else
					{
						System.out.println("실패");
					}
					
					psmt.close();
					conn.close();
				} catch (Exception err) {
					err.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(getParent(), "회원가입 처리");
			}
		});
		add(btnJoin);	
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
