package user;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import image.ResizeImage;
import main.Main;
import swing.*;

public class UserJoin extends CPanel {
	private CPanel instance;
	private CTextField txtUserID;
	private CPasswordField txtUserPW;
	private CPasswordField txtUserPW_Re;

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
		txtUserID.setBounds(25, 130, 170, 40);
		add(txtUserID);
		
		CButton btnVerifyID = new CButton("중복확인");
		btnVerifyID.setBounds(211, 130, 161, 40);
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
		
		CTextField txtUserNickname = new CTextField();
		txtUserNickname.setBounds(25, 292, 347, 40);
		add(txtUserNickname);

		
		/////////////////////////
		// 전자 지갑
		/////////////////////////
		CLabel lblWallet = new CLabel("전자지갑 번호");
		lblWallet.setBounds(25, 342, 347, 30);
		add(lblWallet);
		
		CTextField txtUserWallet = new CTextField();
		txtUserWallet.setBounds(25, 374, 170, 40);
		add(txtUserWallet);
		
		CButton btnVerifyWallet = new CButton("인증하기");
		btnVerifyWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), txtUserWallet.getText() + "전자지갑 인층 처리");
			}
		});
		btnVerifyWallet.setBounds(211, 374, 161, 40);
		add(btnVerifyWallet);

	
		//////////////////////////////////
		// 가입하기 버튼
		//////////////////////////////////
		CButton btnJoin = new CButton("가입하기");
		btnJoin.setBounds(25, 594, 347, 40);
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "회원가입 처리");
			}
		});
		add(btnJoin);


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
		
		CLabel lblProfilePic = new CLabel("전자지갑 번호");
		lblProfilePic.setText("프로필 사진");
		lblProfilePic.setBounds(25, 424, 101, 30);
		add(lblProfilePic);
		
		JButton btnNewButton;
		ImageIcon img = ResizeImage.resize("images/sample1.jpg", 130, 130);
		btnNewButton = new CImageButton(img, 130);
		btnNewButton.setBounds(133, 432, 130, 130);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton);
		
	
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
