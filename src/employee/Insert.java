package employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import db.DB;
import swing.CButton;
import swing.CLabel;
import swing.CTextField;

public class Insert extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CTextField txtUserID;
	private CTextField txtUserPW;
	private CTextField txtUserPWRe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Insert() {
		// 경고창을 조금 바꿈
		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("Panel.background", Color.WHITE);
		UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.PLAIN, 16)); 
		UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.PLAIN, 16));
		
		
		initComponents();
	}
	
	private void initComponents() {
		setResizable(false);
		setBounds(100, 100, 360, 564);
		setLocationRelativeTo(getRootPane());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#1A1A25"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CLabel lblNewLabel = new CLabel("신규 등록하기");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(12, 10, 320, 34);
		contentPane.add(lblNewLabel);
		
		txtUserID = new CTextField();
		txtUserID.setBounds(39, 94, 264, 30);
		contentPane.add(txtUserID);
		
		txtUserPW = new CTextField();
		txtUserPW.setBounds(39, 174, 264, 30);
		contentPane.add(txtUserPW);
		
		txtUserPWRe = new CTextField();
		txtUserPWRe.setBounds(39, 251, 264, 30);
		contentPane.add(txtUserPWRe);
		txtUserPWRe.setColumns(10);
		
		CLabel lblUserID = new CLabel("회원 아이디");
		lblUserID.setBounds(39, 54, 107, 30);
		contentPane.add(lblUserID);
		
		CLabel lblUserPW = new CLabel("회원 비밀번호");
		lblUserPW.setBounds(39, 134, 107, 30);
		contentPane.add(lblUserPW);
		
		CLabel lblUserPWRe = new CLabel("비밀번호 확인");
		lblUserPWRe.setBounds(39, 214, 107, 30);
		contentPane.add(lblUserPWRe);
		
		
		CButton btnInsert = new CButton("입력하기");
		btnInsert.setBounds(39, 473, 264, 30);
		btnInsert.addActionListener(new InsertUser());

		contentPane.add(btnInsert);
		
		CLabel lblUserBirth = new CLabel("생년월일");
		lblUserBirth.setText("생년월일");
		lblUserBirth.setBounds(39, 298, 107, 30);
		contentPane.add(lblUserBirth);
		
		CTextField txtUserBirth = new CTextField();
		txtUserBirth.setColumns(10);
		txtUserBirth.setBounds(39, 335, 264, 30);
		contentPane.add(txtUserBirth);
		
		CLabel lblUserNick = new CLabel("별명");
		lblUserNick.setText("별명");
		lblUserNick.setBounds(39, 381, 107, 30);
		contentPane.add(lblUserNick);
		
		CTextField txtUserNick = new CTextField();
		txtUserNick.setColumns(10);
		txtUserNick.setBounds(39, 418, 264, 30);
		contentPane.add(txtUserNick);
	}

	class InsertUser implements ActionListener {
		
		
		Connection conn = null; 
		PreparedStatement psmt = null;
		ResultSet rs = null;
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (txtUserID.getText().equals("")) {
				JOptionPane.showMessageDialog(getRootPane(), "아이디를 입력하시오.", "확인", JOptionPane.INFORMATION_MESSAGE);
				txtUserID.requestFocus();
				return;
			}
			
			if (txtUserPW.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하시오.");
				txtUserPW.requestFocus();
				return;
			}
			
			if (!txtUserPW.getText().equals(txtUserPWRe.getText())) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				txtUserPWRe.requestFocus();
				return;
			}
			
			///////////////////////////////////////////////
			// 디비에 입력해보자
			///////////////////////////////////////////////
			String sql = "insert into USER_T(USER_NO, USER_ID, USER_PASS, USER_CREDAY) values (SEQ_INCREASE_USER_NO,?, ?, sysdate)";
			
			
			try {
				conn = DB.get();
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, txtUserID.getText());
				psmt.setString(2, txtUserPW.getText());

				int n = psmt.executeUpdate(); // DB 갱신됨
				System.out.println(n>0 ? "성공" : "실패");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}
}
