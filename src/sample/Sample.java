package sample;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import main.Main;
import swing.CButton;
import swing.CLabel;
import swing.CPanel;
import swing.CTextField;

public class Sample extends CPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CPanel instance;
	private CTextField txtUserID;
	private CTextField txtUserPW;

	public Sample() {
		this(0);
	}
	
	
	public Sample(int roundSize) {
		super(roundSize);
		this.instance = this;
		initComponents();
	}
	
	private void initComponents() {

		/////////////////////////
		// 패널 기본 설정
		/////////////////////////
		setLayout(null);
		setBackground(Color.decode("#1A1A25"));
		setBounds(100, 0, 400, 436);
		
		CLabel lblTitle = new CLabel("로그인");
		lblTitle.setBounds(25, 26, 174, 50);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		add(lblTitle);
		
		CLabel lblID = new CLabel("아이디");
		lblID.setBounds(25, 94, 347, 30);
		add(lblID);
		
		txtUserID = new CTextField();
		txtUserID.setBounds(25, 127, 347, 40);
		add(txtUserID);
		
		CLabel lblPW = new CLabel("비밀번호");
		lblPW.setBounds(25, 180, 347, 30);
		add(lblPW);
		
		txtUserPW = new CTextField();
		txtUserPW.setBounds(25, 213, 347, 40);
		add(txtUserPW);

		
		//////////////////////////////////
		// 로그인 버튼
		//////////////////////////////////
		CButton btnLogin = new CButton("로 그 인");
		btnLogin.setBounds(25, 272, 347, 40);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그인처리");
			}
		});
		add(btnLogin);

		
		//////////////////////////////////
		// 회원가입
		//////////////////////////////////
		CButton btnJoin = new CButton("회원 가입", "DARK");
		btnJoin.setBounds(229, 353, 143, 25);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnJoin);
		
		CLabel lblNoUser = new CLabel("아직 회원이 아니신가요?");
		lblNoUser.setBounds(25, 350, 347, 30);
		add(lblNoUser);


		//////////////////////////////////
		// 비밀번호 찾기
		//////////////////////////////////
		CButton btnFindPw = new CButton("비밀번호 찾기", "DARK");
		btnFindPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindPw.setBounds(229, 388, 143, 25);
		add(btnFindPw);

		CLabel lblFindPw = new CLabel("비밀번호를 잊으셨나요?");
		lblFindPw.setBounds(25, 385, 347, 30);
		add(lblFindPw);


		//////////////////////////////////
		// 패널 닫기
		//////////////////////////////////
		CLabel lblClose = new CLabel("X");
		lblClose.setFont(new Font("Arial", Font.PLAIN, 40));
		lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblClose.setBounds(345, 27, 27, 45);
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
