package user;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.Main;
import swing.*;

public class UserJoin extends CPanel {
	private CPanel instance;
	private CTextField txtUserID;
	private CPasswordField txtUserPW;
	private CPasswordField txtUserPW_Re;

	public UserJoin() {
		this(0);
	}
	
	public UserJoin(int roundSize) {
		super(roundSize);
		this.instance = this;
		initComponents();
	}
	
	private void initComponents() {

		/////////////////////////
		// 패널 기본 설정
		/////////////////////////
		setBounds(100, 0, 400, 600);
		
		CLabel lblTitle = new CLabel("회원가입");
		lblTitle.setBounds(25, 26, 174, 50);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		add(lblTitle);
		
		CLabel lblID = new CLabel("아이디 (이메일)");
		lblID.setBounds(25, 94, 347, 30);
		add(lblID);
		
		txtUserID = new CTextField();
		txtUserID.setBounds(25, 130, 347, 40);
		add(txtUserID);
		
		CLabel lblPW = new CLabel("비밀번호");
		lblPW.setBounds(25, 180, 347, 30);
		add(lblPW);
		
		txtUserPW = new CPasswordField();
		txtUserPW.setBounds(25, 213, 347, 40);
		add(txtUserPW);

		

		
		CLabel lblPWCheck = new CLabel("비밀번호 확인");
		lblPWCheck.setBounds(25, 263, 347, 30);
		add(lblPWCheck);
		
		txtUserPW_Re = new CPasswordField();
		txtUserPW_Re.setBounds(25, 298, 347, 40);
		add(txtUserPW_Re);
		
		CLabel lblNickname = new CLabel("닉네임");
		lblNickname.setBounds(25, 346, 347, 30);
		add(lblNickname);
		
		CTextField txtUserNickname = new CTextField();
		txtUserNickname.setBounds(25, 379, 347, 40);
		add(txtUserNickname);
		
		CLabel lblWallet = new CLabel("전자지갑 번호");
		lblWallet.setBounds(25, 429, 347, 30);
		add(lblWallet);
		
		CTextField txtUserWallet = new CTextField();
		txtUserWallet.setBounds(25, 464, 174, 40);
		add(txtUserWallet);
		
		CButton btnVerifyWallet = new CButton("인증하기");
		btnVerifyWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "전자지갑 인층 처리");
			}
		});
		btnVerifyWallet.setBounds(211, 464, 161, 40);
		add(btnVerifyWallet);

	
		//////////////////////////////////
		// 가입하기 버튼
		//////////////////////////////////
		CButton btnJoin = new CButton("가입하기");
		btnJoin.setBounds(25, 528, 347, 40);
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
		CLabel lblClose = new CLabel("X");
		lblClose.setFont(new Font("Arial", Font.PLAIN, 40));
		lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblClose.setBounds(361, 10, 27, 45);
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				instance.setVisible(false);
			}
		});
		add(lblClose);	
	
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
