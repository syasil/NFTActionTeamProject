package user;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import functions.SlidingAnimate;
import main.Main;
import swing.*;

public class FindPassword extends CPanel {
	private FindPassword instance;
	private CTextField txtUserID;
	private CPasswordField txtUserPW;
	
	public FindPassword() {
		super(30);
		this.instance = this;
		initComponents();
	}
	
	private void initComponents() {

		/////////////////////////
		// 패널 기본 설정
		/////////////////////////
		setBounds(100, 0, 400, 350);
		setVisible(false);


		//////////////////////////////////
		// 패널 닫기
		//////////////////////////////////
		CLabel lblClose = new CLabel("×", 40);
		lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblClose.setBounds(358, 12, 30, 30);
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				instance.setVisible(false);
				Main.pnlOpaque.setVisible(false);
			}
		});
		add(lblClose);

		
		/////////////////////////
		// 디자인
		/////////////////////////
		CLabel lblTitle = new CLabel("비밀번호 찾기", 28);
		lblTitle.setBounds(25, 26, 321, 50);
		add(lblTitle);
		
		CLabel lblID = new CLabel("아이디 (이메일)");
		lblID.setBounds(25, 94, 347, 30);
		add(lblID);
		
		txtUserID = new CTextField();
		txtUserID.setBounds(25, 127, 347, 40);
		add(txtUserID);
		
		CLabel lblPW = new CLabel("비밀번호");
		lblPW.setBounds(25, 180, 347, 30);
		add(lblPW);
		
		txtUserPW = new CPasswordField();
		txtUserPW.setBounds(25, 213, 347, 40);
		add(txtUserPW);

		
		//////////////////////////////////
		// 비밀번호 찾기 버튼
		//////////////////////////////////
		CButton btnFindPW = new CButton("비밀번호 찾기");
		btnFindPW.setBounds(25, 279, 347, 40);
		btnFindPW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "비밀번호 찾기 처리");
			}
		});
		add(btnFindPW);
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
